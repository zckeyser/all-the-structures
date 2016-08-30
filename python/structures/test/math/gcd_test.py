import unittest

import structures.src.math.gcd as gcd

class TestEuclideanAlgorithm(unittest.TestCase):
    def test_gcd(self):
        self.assertEquals(gcd.gcd(24, 36), 12)

        self.assertEquals(gcd.gcd(374, 8), 2)

        self.assertEquals(gcd.gcd(7, 31), 1)
