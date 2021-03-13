import structures.src.sorts.bubble as bubble_sort
from structures.src.util.sort_util import random_array, is_sorted
import structures.src.util.constants as const


def test_sorted():
    arr = random_array(const.ARRAY_SIZE)

    # make sure the starting array isn't sorted
    assert not is_sorted(arr)

    # sort the array
    result = bubble_sort.sort(arr)

    # make sure it worked
    assert is_sorted(result)
