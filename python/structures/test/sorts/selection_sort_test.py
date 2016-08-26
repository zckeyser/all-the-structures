import unittest

import structures.src.sorts.selection as selection_sort
import structures.src.util.sort_util as util
import structures.src.util.constants as const

class TestSelectionSort(unittest.TestCase):
    def test_sorted(self):
        arr = util.random_array(const.ARRAY_SIZE)

        # make sure the starting array isn't sorted
        self.assertFalse(util.is_sorted(arr))

        # sort the array
        result = selection_sort.sort(arr)

        # make sure it worked
        self.assertTrue(util.is_sorted(result))

if __name__ == '__main__':
    unittest.main()
