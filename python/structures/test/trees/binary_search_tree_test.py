import unittest

import structures.src.trees.binary_search_tree as tree
import structures.src.trees.traversal as traversal

class TestBinarySearchTree(unittest.TestCase):
    def setUp(self):
        self.root = tree.BinarySearchTree(None, 50)

        self.root.insert(10)
        self.root.insert(30)
        self.root.insert(42)
        self.root.insert(15)
        self.root.insert(3)
        self.root.insert(60)
        self.root.insert(80)
        self.root.insert(83)
        self.root.insert(24)
        self.root.insert(73)
        self.root.insert(87)
        self.root.insert(100)

    def test_insert(self):
        expected = '3 10 15 24 30 42 50 60 73 80 83 87 100'
        self.assertEquals(traversal.inorder(self.root), expected)

    def test_remove_leaf(self):
        self.root.remove(3)

        expected = '10 15 24 30 42 50 60 73 80 83 87 100'
        self.assertEquals(traversal.inorder(self.root), expected)

    def test_remove_single_child(self):
        self.root.remove(10)

        expected = '3 15 24 30 42 50 60 73 80 83 87 100'
        self.assertEquals(traversal.inorder(self.root), expected)

    def test_remove_two_children(self):
        self.root.remove(30)

        expected = '3 10 15 24 42 50 60 73 80 83 87 100'
        self.assertEquals(traversal.inorder(self.root), expected)

    def test_remove_root(self):
        self.root.remove(50)

        expected = '3 10 15 24 30 42 60 73 80 83 87 100'
        self.assertEquals(traversal.inorder(self.root), expected)

    def test_contains(self):
        self.assertTrue(self.root.contains(80))
        self.assertFalse(self.root.contains(150))
