import unittest

from . import graph_gen as generator

import structures.src.searches.graph.dfs as dfs
import structures.src.util.sort_util as util
import structures.src.util.constants as const

class TestDepthFirstSearch(unittest.TestCase):
    def setUp(self):
        self.root = generator.getGraph()

    def test_traverse(self):
        expected = '21 39 27 30 33 36 16 11 84 18 63 14 51'

        result = dfs.traverse(self.root)

        self.assertEquals(result, expected)
