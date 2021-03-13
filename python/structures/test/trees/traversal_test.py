from pytest import fixture

import structures.src.trees.binary_tree as tree
import structures.src.trees.traversal as traversal

#        1
#    2       3
#  4   5   6   7
@fixture(name='tree_root')
def init_tree():
    root = tree.BinaryTree(1)
    root.left = tree.BinaryTree(2)
    root.right = tree.BinaryTree(3)
    root.left.left = tree.BinaryTree(4)
    root.left.right = tree.BinaryTree(5)
    root.right.left = tree.BinaryTree(6)
    root.right.right = tree.BinaryTree(7)

    yield root


def test_preorder(tree_root):
    expected = '1 2 4 5 3 6 7'

    result = traversal.preorder(tree_root)
    
    assert result == expected


def test_inorder(tree_root):
    expected = '4 2 5 1 6 3 7'

    result = traversal.inorder(tree_root)

    assert result == expected


def test_postorder(tree_root):
    expected = '4 5 2 6 7 3 1'

    result = traversal.postorder(tree_root)

    assert result == expected
