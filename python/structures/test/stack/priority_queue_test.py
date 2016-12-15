import unittest

import structures.src.stack.priority_queue as queue

class TestPriorityQueue(unittest.TestCase):
    def setUp(self):
        self.q = queue.PriorityQueue()

    def test_init_is_empty(self):
        self.assertEquals(0, len(self.q))

    def test_single_default_enqueue_is_correct_size(self):
        self.q.enqueue(2, 0)

        self.assertEquals(1, len(self.q))

    def test_single_default_enqueue_extract_maxs_correct_value(self):
        self.q.enqueue(2, 0)

        self.assertEquals(2, self.q.extract_max())

    def test_single_default_enqueue_removes_value_on_extract_max(self):
        self.q.enqueue(2, 0)
        self.q.extract_max()

        self.assertEquals(0, len(self.q))

    def test_single_level_enqueue_is_correct_size(self):
        self.q.enqueue(2, 3)

        self.assertEquals(1, len(self.q))

    def test_single_level_enqueue_extract_maxs_correct_value(self):
        self.q.enqueue(2, 3)

        self.assertEquals(2, self.q.extract_max())

    def test_single_level_enqueue_removes_value_on_extract_max(self):
        self.q.enqueue(2, 3)
        self.q.extract_max()

        self.assertEquals(0, len(self.q))

    def test_each_level_enqueue_correct_size(self):
        self.q.enqueue(5, 0)
        self.q.enqueue(4, 1)
        self.q.enqueue(3, 2)
        self.q.enqueue(2, 3)
        self.q.enqueue(1, 4)

        self.assertEquals(5, len(self.q))

    def test_each_level_enqueue_correct_extract_max_order(self):
        self.q.enqueue(5, 0)
        self.q.enqueue(4, 1)
        self.q.enqueue(3, 2)
        self.q.enqueue(2, 3)
        self.q.enqueue(1, 4)

        self.assertEquals(1, self.q.extract_max())
        self.assertEquals(2, self.q.extract_max())
        self.assertEquals(3, self.q.extract_max())
        self.assertEquals(4, self.q.extract_max())
        self.assertEquals(5, self.q.extract_max())

    def test_each_level_enqueue_removes_on_extract_max(self):
        self.q.enqueue(5, 0)
        self.q.enqueue(4, 1)
        self.q.enqueue(3, 2)
        self.q.enqueue(2, 3)
        self.q.enqueue(1, 4)

        # for test_each extract_max make sure length decrements by 1
        for i in range(4, -1, -1):
            self.q.extract_max()
            self.assertEquals(i, len(self.q))

    def test_varied_multi_level_enqueue_correct_size(self):
        self.q.enqueue(0, 0)
        self.q.enqueue(2, 0)

        self.q.enqueue(4, 1)

        self.q.enqueue(6, 2)
        self.q.enqueue(8, 2)
        self.q.enqueue(10, 2)

        # skip around to make sure insert order for different prios doesn't matter
        self.q.enqueue(12, 4)
        self.q.enqueue(14, 4)
        self.q.enqueue(16, 4)
        self.q.enqueue(18, 4)

        # now fill out prio 3
        self.q.enqueue(20, 3)
        self.q.enqueue(22, 3)

        self.assertEquals(12, len(self.q))

    def test_varied_multi_level_enqueue_correct_extract_maxs(self):
        self.q.enqueue(0, 0)
        self.q.enqueue(2, 0)

        self.q.enqueue(4, 1)

        self.q.enqueue(6, 2)
        self.q.enqueue(8, 2)
        self.q.enqueue(10, 2)

        # skip around to make sure insert order for different prios doesn't matter
        self.q.enqueue(12, 4)
        self.q.enqueue(14, 4)
        self.q.enqueue(16, 4)
        self.q.enqueue(18, 4)

        # now fill out prio 3
        self.q.enqueue(20, 3)
        self.q.enqueue(22, 3)

        # prio 4
        self.assertEquals(12, self.q.extract_max())
        self.assertEquals(14, self.q.extract_max())
        self.assertEquals(16, self.q.extract_max())
        self.assertEquals(18, self.q.extract_max())
        # prio 3
        self.assertEquals(20, self.q.extract_max())
        self.assertEquals(22, self.q.extract_max())
        # prio 2
        self.assertEquals(6, self.q.extract_max())
        self.assertEquals(8, self.q.extract_max())
        self.assertEquals(10, self.q.extract_max())
        # prio 1
        self.assertEquals(4, self.q.extract_max())
        self.assertEquals(0, self.q.extract_max())
        # prio 0
        self.assertEquals(2, self.q.extract_max())

    def test_varied_multi_level_enqueue_removes_on_extract_max(self):
        self.q.enqueue(0, 0)
        self.q.enqueue(2, 0)

        self.q.enqueue(4, 1)

        self.q.enqueue(6, 2)
        self.q.enqueue(8, 2)
        self.q.enqueue(10, 2)

        # skip around to make sure insert order for different prios doesn't matter
        self.q.enqueue(12, 4)
        self.q.enqueue(14, 4)
        self.q.enqueue(16, 4)
        self.q.enqueue(18, 4)

        # now fill out prio 3
        self.q.enqueue(20, 3)
        self.q.enqueue(22, 3)

        # for test_each extract_max make sure length decrements by 1
        for i in range(11, -1, -1):
            self.q.extract_max()
            self.assertEquals(i, len(self.q))
