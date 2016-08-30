import unittest

import structures.src.stack.queue as queue

class TestQueue(unittest.TestCase):
    def setUp(self):
        self.q = queue.Queue()

    def test_starts_empty(self):
        self.assertEquals(len(self.q), 0)

    def test_single_item(self):
        self.q.push(10)

        self.assertEquals(len(self.q), 1)

        result = self.q.pop()

        self.assertEquals(result, 10)
        self.assertEquals(len(self.q), 0)

    def test_multiple_items(self):
        self.q.push(10)
        self.q.push(20)

        self.assertEquals(len(self.q), 2)

        result = self.q.pop()

        self.assertEquals(result, 10)
        self.assertEquals(len(self.q), 1)

        result = self.q.pop()

        self.assertEquals(result, 20)
        self.assertEquals(len(self.q), 0)
