from . import graph_gen as generator

import structures.src.searches.graph.dfs as dfs


def test_traverse():
    root = generator.get_graph()

    expected = '21 39 27 30 33 36 16 11 84 18 63 14 51'

    result = dfs.traverse(root)

    assert result == expected
