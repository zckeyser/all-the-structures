import unittest

import structures.src.searches.list.binary as binarySearch

class TestBinarySearch(unittest.TestCase):
    def test_contains(self):
        arr = range(0, 2000, 3)

        # lower half
        self.assertTrue(binarySearch.contains(arr, 27))

        # top half
        self.assertTrue(binarySearch.contains(arr, 1800))

        # in range
        self.assertFalse(binarySearch.contains(arr, 28))

        # below range
        self.assertFalse(binarySearch.contains(arr, -1))

        # above range
        self.assertFalse(binarySearch.contains(arr, 2000))
