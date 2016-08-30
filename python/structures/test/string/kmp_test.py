import unittest

import structures.src.string.kmp as kmp

class TestKnuthMorrisPratt(unittest.TestCase):
    def setUp(self):
        self.__target = 'foobar'

    def test_target_at_start(self):
        s = self.__target + ('abcd' * 80)
        expected = 0

        result = kmp.kmp(s, self.__target)

        self.assertEquals(result, expected)

    def test_target_in_middle(self):
        s = ('abcd' * 40) + self.__target + ('abcd' * 40)
        expected = 160

        result = kmp.kmp(s, self.__target)

        self.assertEquals(result, expected)

    def test_target_at_end(self):
        s = ('abcd' * 80) + self.__target
        expected = 320

        result = kmp.kmp(s, self.__target)

        self.assertEquals(result, expected)

    def test_no_target(self):
        s = ('abcd' * 80)
        expected = -1

        result = kmp.kmp(s, self.__target)

        self.assertEquals(result, expected)
