import unittest

import structures.src.stack.priority_queue as queue

class TestPriorityQueue(unittest.TestCase):
    def setUp(self):
        self.q = queue.PriorityQueue(5)

    def test_init_is_empty(self):
        self.assertEquals(0, len(self.q))

    def test_init_has_correct_level_count(self):
        self.assertEquals(5, self.q.levels())

    def test_single_default_push_is_correct_size(self):
        self.q.push(2)

        self.assertEquals(1, len(self.q))

    def test_single_default_push_pops_correct_value(self):
        self.q.push(2)

        self.assertEquals(2, self.q.pop())

    def test_single_default_push_removes_value_on_pop(self):
        self.q.push(2)
        self.q.pop()

        self.assertEquals(0, len(self.q))

    def test_single_level_push_is_correct_size(self):
        self.q.push(2, 3)

        self.assertEquals(1, len(self.q))

    def test_single_level_push_pops_correct_value(self):
        self.q.push(2, 3)

        self.assertEquals(2, self.q.pop())

    def test_single_level_push_removes_value_on_pop(self):
        self.q.push(2, 3)
        self.q.pop()

        self.assertEquals(0, len(self.q))

    def test_multiple_default_push_is_correct_size(self):
        self.q.push(2)
        self.q.push(4)

        self.assertEquals(2, len(self.q))

    def test_multiple_default_push_pops_correct_values(self):
        self.q.push(2)
        self.q.push(4)

        self.assertEquals(2, self.q.pop())
        self.assertEquals(4, self.q.pop())

    def test_multiple_default_push_removes_on_pop(self):
        self.q.push(2)
        self.q.push(4)

        self.q.pop()
        self.q.pop()

        self.assertEquals(0, len(self.q))

    def test_each_level_push_correct_size(self):
        self.q.push(5, 0)
        self.q.push(4, 1)
        self.q.push(3, 2)
        self.q.push(2, 3)
        self.q.push(1, 4)

        self.assertEquals(5, len(self.q))

    def test_each_level_push_correct_pop_order(self):
        self.q.push(5, 0)
        self.q.push(4, 1)
        self.q.push(3, 2)
        self.q.push(2, 3)
        self.q.push(1, 4)

        self.assertEquals(1, self.q.pop())
        self.assertEquals(2, self.q.pop())
        self.assertEquals(3, self.q.pop())
        self.assertEquals(4, self.q.pop())
        self.assertEquals(5, self.q.pop())

    def test_each_level_push_removes_on_pop(self):
        self.q.push(5, 0)
        self.q.push(4, 1)
        self.q.push(3, 2)
        self.q.push(2, 3)
        self.q.push(1, 4)

        # for test_each pop make sure length decrements by 1
        for i in range(4, -1, -1):
            self.q.pop()
            self.assertEquals(i, len(self.q))

    def test_varied_multi_level_push_correct_size(self):
        self.q.push(0, 0)
        self.q.push(2, 0)

        self.q.push(4, 1)

        self.q.push(6, 2)
        self.q.push(8, 2)
        self.q.push(10, 2)

        # skip around to make sure insert order for different prios doesn't matter
        self.q.push(12, 4)
        self.q.push(14, 4)
        self.q.push(16, 4)
        self.q.push(18, 4)

        # now fill out prio 3
        self.q.push(20, 3)
        self.q.push(22, 3)

        self.assertEquals(12, len(self.q))

    def test_varied_multi_level_push_correct_pops(self):
        self.q.push(0, 0)
        self.q.push(2, 0)

        self.q.push(4, 1)

        self.q.push(6, 2)
        self.q.push(8, 2)
        self.q.push(10, 2)

        # skip around to make sure insert order for different prios doesn't matter
        self.q.push(12, 4)
        self.q.push(14, 4)
        self.q.push(16, 4)
        self.q.push(18, 4)

        # now fill out prio 3
        self.q.push(20, 3)
        self.q.push(22, 3)

        # prio 4
        self.assertEquals(12, self.q.pop())
        self.assertEquals(14, self.q.pop())
        self.assertEquals(16, self.q.pop())
        self.assertEquals(18, self.q.pop())
        # prio 3
        self.assertEquals(20, self.q.pop())
        self.assertEquals(22, self.q.pop())
        # prio 2
        self.assertEquals(6, self.q.pop())
        self.assertEquals(8, self.q.pop())
        self.assertEquals(10, self.q.pop())
        # prio 1
        self.assertEquals(4, self.q.pop())
        self.assertEquals(0, self.q.pop())
        # prio 0
        self.assertEquals(2, self.q.pop())

    def test_varied_multi_level_push_removes_on_pop(self):
        self.q.push(0, 0)
        self.q.push(2, 0)

        self.q.push(4, 1)

        self.q.push(6, 2)
        self.q.push(8, 2)
        self.q.push(10, 2)

        # skip around to make sure insert order for different prios doesn't matter
        self.q.push(12, 4)
        self.q.push(14, 4)
        self.q.push(16, 4)
        self.q.push(18, 4)

        # now fill out prio 3
        self.q.push(20, 3)
        self.q.push(22, 3)

        # for test_each pop make sure length decrements by 1
        for i in range(11, -1, -1):
            self.q.pop()
            self.assertEquals(i, len(self.q))
