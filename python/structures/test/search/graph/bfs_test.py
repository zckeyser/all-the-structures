from . import graph_gen as generator

import structures.src.searches.graph.bfs as bfs


def test_traverse():
    root = generator.get_graph()

    expected = '21 14 18 39 51 63 16 27 84 11 30 33 36'

    result = bfs.traverse(root)

    assert result == expected
