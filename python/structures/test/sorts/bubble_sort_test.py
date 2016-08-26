import unittest

import structures.src.sorts.bubble_sort
import structures.src.util.sort_util

class TestBubbleSort(unittest.TestCase):
    def test_sorted(self):
        arr = sort_util.random_array(1000)

        # make sure the starting array isn't sorted
        self.assertFalse(sort_util.is_sorted(arr))

        # sort the array
        result = bubble_sort.sort(arr)

        # make sure it worked
        self.assertTrue(sort_util.is_sorted(arr))

if __name__ == '__main__':
    unittest.main()
