module Dictionary where

import Data.Maybe

import qualified LinkedList as LinkedList
import StringHash

type Dictionary v = [LinkedList (String, v)]

newDict :: Dictionary k v
newDict = arrayOf LinkedList.EmptyNode defaultSize
  where
    arrayOf :: a -> Int -> [a]
    arrayOf _ 0 = []
    arrayOf a i = a : arrayOf a (i - 1)

    defaultSize = 1024

insert :: Dictionary a -> String -> a -> Dictionary a
insert d k v
  | isBucketEmpty bucket  = replaceElement d index newNode -- no collision
  | isJust keyMatchedNode = replaceElement d index $ LinkedList.replaceWhere (matchingKey k) bucket (Node (k, v) (LinkedList.rest $ fromJust keyMatchedNode))
  | otherwise             = replaceElement d index $ append bucket newNode
  where
    index = hash k `mod` length d
    bucket = d ! index

    replaceElement :: [a] -> Integer -> a -> [a]
    replaceElement (x:xs) n x'
        | n == 0    = x' : xs
        | otherwise = x : replaceElement xs x' n

    isBucketEmpty :: LinkedList (String, v) -> Bool
    isBucketEmpty (Node _ _ ) = True
    isBucketEmpty EmptyNode   = False

    matchingKey :: String -> (String, v) -> Bool
    matchingKey s p = s == fst p

    keyMatchedNode = LinkedList.find (matchingKey k) bucket

    newNode = LinkedList.newNode (k, v)
