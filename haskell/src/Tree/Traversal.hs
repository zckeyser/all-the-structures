module Tree.Traversal where

import Tree.BST as BST

preorder :: BST.Tree a -> [a]
preorder BST.EmptyTree      = []
preorder (BST.Node x l r _) = [x] ++ preorder l ++ preorder r

inorder :: BST.Tree a -> [a]
inorder BST.EmptyTree      = []
inorder (BST.Node x l r _) = inorder l ++ [x] ++ inorder r

postorder :: BST.Tree a -> [a]
postorder BST.EmptyTree      = []
postorder (BST.Node x l r _) = postorder l ++ postorder r ++ [x]
