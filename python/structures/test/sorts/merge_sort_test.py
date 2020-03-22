import unittest

import structures.src.sorts.merge as merge_sort
import structures.src.util.constants as const
from structures.src.util.sort_util import is_sorted, random_array

class TestMergeSort(unittest.TestCase):
    def test_sorted(self):
        arr = random_array(const.ARRAY_SIZE)

        # make sure the starting array isn't sorted
        self.assertFalse(is_sorted(arr))

        # sort the array
        result = merge_sort.merge_sort(arr)

        # make sure it worked
        self.assertTrue(is_sorted(result))

if __name__ == '__main__':
    unittest.main()
