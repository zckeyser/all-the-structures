import unittest

from . import graph_gen as generator

import structures.src.searches.graph.bfs as bfs
import structures.src.util.sort_util as util
import structures.src.util.constants as const

class TestBreadthFirstSearch(unittest.TestCase):
    def setUp(self):
        self.root = generator.getGraph()

    def test_traverse(self):
        expected = '21 14 18 39 51 63 16 27 84 11 30 33 36'

        result = bfs.traverse(self.root)

        self.assertEquals(result, expected)
