module Core.LinkedList where

import Data.Maybe

data List a = EmptyNode | Node{value :: a, rest :: List a} deriving (Eq, Show, Read)

newNode :: a -> List a
newNode x = (Node x EmptyNode)

isEmpty :: List a -> Bool
isEmpty EmptyNode = True
isEmpty _ = False

any' :: (a -> Bool) -> List a -> Bool
any' _ EmptyNode = False
any' f (Node x n)
  | f x        = True
  | otherwise  = any' f n

contains :: Eq a => List a -> a -> Bool
contains EmptyNode _ = False
contains (Node x' n) x
  | x == x'   = True
  | otherwise = contains n x

-- look for a value in the list which matches the given predicate
find :: (a -> Bool) -> List a -> Maybe a
find _ EmptyNode = Nothing
find f (Node x n)
  | f x        = Just x
  | otherwise  = find f n

findNode :: (a -> Bool) -> List a -> Maybe (List a)
findNode _ EmptyNode = Nothing
findNode f curr@(Node x n)
  | f x        = Just curr
  | otherwise  = findNode f n

-- replace the first value that matches f with x
replaceWhere :: (a -> Bool) -> a -> List a -> List a
replaceWhere _ _ EmptyNode = EmptyNode
replaceWhere f x (Node x' n)
  | f x'      = (Node x n)
  | otherwise = (Node x' (replaceWhere f x n))

append :: List a -> a -> List a
append EmptyNode x   = newNode x
append (Node x' n) x = (Node x' (append n x))

fromList :: [a] -> List a
fromList [] = EmptyNode
fromList (x:xs) = (Node x (fromList xs))

toList :: List a -> [a]
toList EmptyNode = []
toList (Node x n) = x : toList n
