import unittest

import structures.src.stack.stack as stack

class TestStack(unittest.TestCase):
    def setUp(self):
        self.s = stack.Stack()

    def test_starts_empty(self):
        self.assertEquals(len(self.s), 0)

    def test_single_item(self):
        self.s.push(10)

        self.assertEquals(len(self.s), 1)

        result = self.s.pop()

        self.assertEquals(result, 10)
        self.assertEquals(len(self.s), 0)

    def test_multiple_items(self):
        self.s.push(10)
        self.s.push(20)

        self.assertEquals(len(self.s), 2)

        result = self.s.pop()

        self.assertEquals(result, 20)
        self.assertEquals(len(self.s), 1)

        result = self.s.pop()

        self.assertEquals(result, 10)
        self.assertEquals(len(self.s), 0)
