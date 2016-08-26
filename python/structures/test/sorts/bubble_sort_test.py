import unittest

import structures.src.sorts.bubble as bubble_sort
import structures.src.util.sort_util as util

class TestBubbleSort(unittest.TestCase):
    def test_sorted(self):
        arr = util.random_array(1000)

        # make sure the starting array isn't sorted
        self.assertFalse(util.is_sorted(arr))

        # sort the array
        result = bubble_sort.sort(arr)

        # make sure it worked
        self.assertTrue(util.is_sorted(arr))

if __name__ == '__main__':
    unittest.main()
