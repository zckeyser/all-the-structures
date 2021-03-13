import pytest

import structures.src.trees.binary_search_tree as tree
import structures.src.trees.traversal as traversal


@pytest.fixture(name='bst_root')
def init_bst():
    root = tree.BinarySearchTree(None, 50)

    root.insert(10)
    root.insert(30)
    root.insert(42)
    root.insert(15)
    root.insert(3)
    root.insert(60)
    root.insert(80)
    root.insert(83)
    root.insert(24)
    root.insert(73)
    root.insert(87)
    root.insert(100)

    yield root


def test_insert(bst_root):
    expected = '3 10 15 24 30 42 50 60 73 80 83 87 100'
    assert traversal.inorder(bst_root) == expected


def test_remove_leaf(bst_root):
    bst_root.remove(3)

    expected = '10 15 24 30 42 50 60 73 80 83 87 100'
    assert traversal.inorder(bst_root) == expected


def test_remove_single_child(bst_root):
    bst_root.remove(10)

    expected = '3 15 24 30 42 50 60 73 80 83 87 100'
    assert traversal.inorder(bst_root) == expected


def test_remove_two_children(bst_root):
    bst_root.remove(30)

    expected = '3 10 15 24 42 50 60 73 80 83 87 100'
    assert traversal.inorder(bst_root) == expected


def test_remove_root(bst_root):
    bst_root.remove(50)

    expected = '3 10 15 24 30 42 60 73 80 83 87 100'
    assert traversal.inorder(bst_root) == expected

@pytest.mark.parametrize(
    "value,expected",
    [
        (80, True),
        (150, False)
    ]
)
def test_contains(value, expected, bst_root):
    assert bst_root.contains(value) == expected
