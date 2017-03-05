module BinarySearchTree where

import Data.Boolean

data Tree a = EmptyTree | Node { value :: a, left :: Tree a, right :: Tree a, count :: Int } deriving (Show, Read, Eq)

singleton :: (Ord a) => a -> Tree a
singleton x = (Node x EmptyTree EmptyTree 1)

insert :: (Ord a) => Tree a -> a -> Tree a
insert EmptyTree x = singleton x
insert t x
    | x < value t = if left t == EmptyTree
                    then (Node (value t) (singleton x) (right t) (count t))
                    else (Node (value t) (insert (left t) x) (right t) (count t))
    | x > value t = if right t == EmptyTree
                    then (Node (value t) (left t) (singleton x) (count t))
                    else (Node (value t) (left t) (insert (right t) x) (count t))
    | otherwise = (Node (value t) (left t) (right t) (count t + 1))

delete :: (Ord a) => Tree a -> a -> Tree a
delete t x
    | x < value t          = if left t /= EmptyTree
                            then (Node (value t) (delete (left t) x) (right t) (count t))
                            else t
    | x > value t          = if right t /= EmptyTree
                            then (Node (value t) (left t) (delete (right t) x) (count t))
                            else t
    | count t > 1          = (Node (value t) (left t) (right t) (count t - 1))
    | left t /= EmptyTree  = let sub = rightmost $ left t -- replace with the rightmost node of the left subtree
                                 newLeft = hardDelete (left t) (value sub)
                             in (Node (value sub) newLeft (right t) (count sub))
    | right t /= EmptyTree = let sub = leftmost $ right t -- replace with the leftmost node of the right subtree
                                 newRight = hardDelete (right t) (count sub)
                             in (Node (value sub) (left t) newRight (count sub))
    | otherwise            = EmptyTree -- delete this node entirely

-- delete a node regardless of its count, for internal use
hardDelete :: (Ord a) => Tree a -> a -> Tree a
hardDelete t x
    | x < value t          = if left t /= EmptyTree
                             then (Node (value t) (hardDelete (left t) x) (right t) (count t))
                             else t
    | x > value t          = if right t /= EmptyTree
                             then (Node (value t) (left t) (hardDelete (right t) x) (count t))
                             else t
    | left t /= EmptyTree  = let sub = rightmost $ left t -- replace with the rightmost node of the left subtree
                                 newLeft = hardDelete (left t) (value sub)
                             in (Node (value sub) newLeft (right t) (count sub))
    | right t /= EmptyTree = let sub = leftmost $ right t -- replace with the leftmost node of the right subtree
                                 newRight = hardDelete (right t) (count sub)
                             in (Node (value sub) (left t) newRight (count sub))
    | otherwise            = EmptyTree -- delete this node entirely

leaf :: Tree a -> Bool
leaf t = and [left t == EmptyTree, right t == EmptyTree]

singleChild :: Tree a -> bool
singleChild t = if left t == EmptyTree -- hard coded xor since there's no prelude function for it
                then right t /= EmptyTree
                else right t == EmptyTree

-- returns the rightmost node of the tree
rightmost :: Tree a -> Tree a
rightmost t
    | right t == EmptyTree = t
    | otherwise            = rightmost $ right t

-- returns the leftmost node of the tree
leftmost :: Tree a -> Tree a
leftmost t
    | left t == EmptyTree = t
    | otherwise           = leftmost $ left t
