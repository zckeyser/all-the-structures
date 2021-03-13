from pytest import fixture

from structures.src.string.kmp import knuth_morris_pratt_string_search


@fixture()
def base_string():
    yield 'foobar'


def test_target_at_start(base_string):
    s = base_string + ('abcd' * 80)
    expected = 0

    result = knuth_morris_pratt_string_search(s, base_string)

    assert result == expected


def test_target_in_middle(base_string):
    s = ('abcd' * 40) + base_string + ('abcd' * 40)
    expected = 160

    result = knuth_morris_pratt_string_search(s, base_string)

    assert result == expected


def test_target_at_end(base_string):
    s = ('abcd' * 80) + base_string
    expected = 320

    result = knuth_morris_pratt_string_search(s, base_string)

    assert result == expected


def test_no_target(base_string):
    s = ('abcd' * 80)
    expected = -1

    result = knuth_morris_pratt_string_search(s, base_string)

    assert result == expected
