import structures.src.sorts.insertion as insertion_sort
from structures.src.util.sort_util import random_array, is_sorted
import structures.src.util.constants as const


def test_sorted():
    arr = random_array(const.ARRAY_SIZE)

    # make sure the starting array isn't sorted
    assert not is_sorted(arr)

    # sort the array
    result = insertion_sort.sort(arr)

    # make sure it worked
    assert is_sorted(result)
