import unittest

from structures.src.string.kmp import knuth_morris_pratt_string_search

class TestKnuthMorrisPratt(unittest.TestCase):
    def setUp(self):
        self.__target = 'foobar'

    def test_target_at_start(self):
        s = self.__target + ('abcd' * 80)
        expected = 0

        result = knuth_morris_pratt_string_search(s, self.__target)

        self.assertEquals(result, expected)

    def test_target_in_middle(self):
        s = ('abcd' * 40) + self.__target + ('abcd' * 40)
        expected = 160

        result = knuth_morris_pratt_string_search(s, self.__target)

        self.assertEquals(result, expected)

    def test_target_at_end(self):
        s = ('abcd' * 80) + self.__target
        expected = 320

        result = knuth_morris_pratt_string_search(s, self.__target)

        self.assertEquals(result, expected)

    def test_no_target(self):
        s = ('abcd' * 80)
        expected = -1

        result = knuth_morris_pratt_string_search(s, self.__target)

        self.assertEquals(result, expected)
