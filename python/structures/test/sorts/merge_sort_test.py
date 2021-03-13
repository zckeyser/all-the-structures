import structures.src.sorts.merge as merge_sort
import structures.src.util.constants as const
from structures.src.util.sort_util import is_sorted, random_array


def test_sorted():
    arr = random_array(const.ARRAY_SIZE)

    # make sure the starting array isn't sorted
    assert not is_sorted(arr)

    # sort the array
    result = merge_sort.merge_sort(arr)

    # make sure it worked
    assert is_sorted(result)
