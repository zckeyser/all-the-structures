module Tree.BinarySearchTree
( EmptyTree
, BinarySearchTree (..)
, insert
, delete
) where

type EmptyTree = None

data BinarySearchTree a = EmptyTree | Node a { value :: a, }
