import unittest

import structures.src.math.eratosthenes as eratosthenes

class TestEratosthenesSieve(unittest.TestCase):
    def test_sieve(self):
        expected = [ 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97 ]

        result = eratosthenes.sieve(100)

        self.assertEquals(len(result), len(expected))

        for i in range(0, len(result)):
            self.assertEquals(result[i], expected[i])
