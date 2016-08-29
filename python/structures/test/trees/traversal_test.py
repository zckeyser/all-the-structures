import unittest

import structures.src.trees.binary_tree as tree
import structures.src.trees.traversal as traversal

class TestTreeTraversal(unittest.TestCase):
    #        1
    #    2       3
    #  4   5   6   7
    def setUp(self):
        self.root = tree.BinaryTree(1)
        self.root.left = tree.BinaryTree(2)
        self.root.right = tree.BinaryTree(3)
        self.root.left.left = tree.BinaryTree(4)
        self.root.left.right = tree.BinaryTree(5)
        self.root.right.left = tree.BinaryTree(6)
        self.root.right.right = tree.BinaryTree(7)

    def test_preorder(self):
        expected = '1 2 4 5 3 6 7'

        result = traversal.preorder(self.root)

        self.assertEquals(result, expected)

    def test_inorder(self):
        expected = '4 2 5 1 6 3 7'

        result = traversal.inorder(self.root)

        self.assertEquals(result, expected)

    def test_postorder(self):
        expected = '4 5 2 6 7 3 1'

        result = traversal.postorder(self.root)

        self.assertEquals(result, expected)
