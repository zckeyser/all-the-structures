import pytest

import structures.src.searches.list.linear as linear_search


@pytest.mark.parametrize(
    "index,expected",
    [
        # lower half
        (27, True),
        # top half
        (1800, True),
        # in range, but doesn't exist in set
        (28, False),
        # below range
        (-1, False),
        # above range
        (2000, False)
    ]
)
def test_contains(index, expected):
    arr = range(0, 2000, 3)

    assert linear_search.contains(arr, index) == expected
