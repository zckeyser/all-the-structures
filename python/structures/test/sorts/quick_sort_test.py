import structures.src.sorts.quick as qsort
from structures.src.util.sort_util import is_sorted, random_array
import structures.src.util.constants as const


def test_sorted():
    arr = random_array(const.ARRAY_SIZE)

    # make sure the starting array isn't sorted
    assert not is_sorted(arr)

    # sort the array
    result = qsort.quicksort(arr)

    # make sure it worked
    assert is_sorted(result)
