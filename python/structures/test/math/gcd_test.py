import pytest

import structures.src.math.gcd as gcd


@pytest.mark.parametrize(
    "a,b,expected",
    [
        (24, 36, 12),
        (374, 8, 2),
        (7, 31, 1)
    ]
)
def test_gcd(a, b, expected):
    assert gcd.gcd(a, b) == expected
