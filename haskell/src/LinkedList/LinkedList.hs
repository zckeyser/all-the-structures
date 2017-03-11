module LinkedList where

import Data.Maybe

data List a = EmptyNode | Node{value :: a, rest :: List a}

newNode :: a -> List a
newNode x = (Node x EmptyNode)

any' :: (a -> Bool) -> List a -> Bool
any' _ EmptyNode = False
any' f (Node x n)
  | f x        = True
  | otherwise  = find f n

contains :: Eq a => List a -> a -> Bool
contains EmptyNode _ = False
contains (Node x' n) x
  | x == x'   = True
  | otherwise = contains n x

-- look for a value in the list which matches the given predicate
find :: (a -> Bool) -> List a -> Maybe a
find _ EmptyNode = None
find f (Node x n)
  | f x        = Just x
  | otherwise  = find f n

replaceWhere :: (a -> Bool) -> List a -> a -> List a
replaceWhere _ EmptyNode _ = EmptyNode
replaceWhere f (Node x' n) x
  | f x'      = (Node x n)
  | otherwise = (Node x' (replaceWhere f n x'))

append :: List a -> a -> List a
append EmptyNode x   = newNode x
append (Node x' n) x = (Node x' (append n x))
