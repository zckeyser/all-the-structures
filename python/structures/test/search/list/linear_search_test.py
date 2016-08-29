import unittest

import structures.src.searches.list.linear as linearSearch

class TestLinearSearch(unittest.TestCase):
    def test_contains(self):
        arr = range(0, 2000, 3)

        # lower half
        self.assertTrue(linearSearch.contains(arr, 27))

        # top half
        self.assertTrue(linearSearch.contains(arr, 1800))

        # in range
        self.assertFalse(linearSearch.contains(arr, 28))

        # below range
        self.assertFalse(linearSearch.contains(arr, -1))

        # above range
        self.assertFalse(linearSearch.contains(arr, 2000))
