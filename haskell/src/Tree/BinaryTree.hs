module Tree.BinaryTree
( EmptyTree
, BinaryTree (..)
, singleton
, insert
, delete
) where

type EmptyTree = None

data BinaryTree a = EmptyTree | Node a { value :: a, left :: (BinaryTree a), right :: (BinaryTree a) } deriving (Eq, Show, Read)

insert :: (Ord a) => a 
