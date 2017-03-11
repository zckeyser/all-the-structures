module Dictionary.Dictionary where

import Data.Maybe

import qualified LinkedList.LinkedList as LinkedList
import Dictionary.StringHash

data Dictionary v = Dictionary{ buckets :: [LinkedList.List (String, v)], size :: Integer }

newDict :: Dictionary a
newDict = (Dictionary (arrayOf LinkedList.EmptyNode defaultSize) 0)
  where
    arrayOf :: a -> Int -> [a]
    arrayOf _ 0 = []
    arrayOf a i = a : arrayOf a (i - 1)

    defaultSize = 1024

set :: Dictionary a -> String -> a -> Dictionary a
set d k v = let updatedDict@(Dictionary b s) = setHelper d k v
            in
              -- after updating the dictionary, make sure we
              -- don't need to expand it (using saturation limit of 70%)
              if s > (.7) * length b
              then expand updatedDict
              else updatedDict
  where
    replaceElement :: [a] -> Integer -> a -> [a]
    replaceElement (x:xs) n x'
        | n == 0    = x' : xs
        | otherwise = x : replaceElement xs x' n

    isBucketEmpty :: LinkedList.List (String, v) -> Bool
    isBucketEmpty (LinkedList.Node _ _ ) = True
    isBucketEmpty LinkedList.EmptyNode   = False

    matchingKey :: String -> (String, v) -> Bool
    matchingKey s p = s == fst p

    setHelper :: Dictionary a -> String -> a -> Dictionary a
    setHelper d@(Dictionary b s) k v
      | isBucketEmpty bucket  = (Dictionary (replaceElement d index newNode) (size + 1)) -- no collision
      | isJust keyMatchedNode = (Dictionary -- update an existing value in this bucket
                                  (replaceElement d index $
                                      LinkedList.replaceWhere (matchingKey k) bucket updatedNode) -- replace the bucket with an updated bucket
                                  (size d)) -- since it's an update, no size change
      | otherwise             = (Dictionary (replaceElement d index $ append bucket newNode) (size d + 1)) -- add this node to the bucket and update size
        where
          index = hash k `mod` length d
          bucket = d !! index

          keyMatchedNode = LinkedList.find (matchingKey k) bucket
          newNode = LinkedList.newNode (k, v)

          -- for updating an existing key
          -- give the node a new value, but keep its tail
          updatedNode = (LinkedList.Node (k, v) (LinkedList.rest $ fromJust keyMatchedNode))

          -- returns a new dictionary equivalent to the given one,
          -- except it has twice as many buckets
          expand :: Dictionary a -> Dictionary a
          expand d@(Dictionary b s) = let d' = (Dictionary (arrayOf LinkedList.EmptyNode $ 2 * length b) 0)
                                      in copy d d' -- copy the existing dict into a new dict
                                                   -- with twice as many buckets
            where
              -- copy the contents of d into d'
              copy :: Dictionary a -> Dictionary a -> Dictionary a
              copy d@(Dictionary b _) d' = lfold (\n -> copyListIntoDict d n) d' b

              copyListIntoDict :: Dictionary a -> LinkedList.List (String, a) -> Dictionary a
              copyListIntoDict d LinkedList.EmptyNode       = d
              copyListIntoDict d (LinkedList.Node (k, v) n) = set (copyListIntoDict n) k v

get :: Dictionary a -> String -> Maybe a
get (Dictionary b _) k
  | isJust keyMatchedNode = keyMatchedNode
  | otherwise = Nothing
  where
    index = hash k `mod` length b
    bucket = b !! index

    matchingKey :: String -> (String, v) -> Bool
    matchingKey s p = s == fst p

    keyMatchedNode = LinkedList.find (matchingKey k) bucket
