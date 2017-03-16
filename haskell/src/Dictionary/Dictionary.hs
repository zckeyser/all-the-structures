module Dictionary.Dictionary where

import Data.Maybe

import qualified Core.LinkedList as LinkedList
import Core.Helper
import Dictionary.StringHash

data Dictionary v = Dictionary{ buckets :: [LinkedList.List (String, v)], size :: Int }

newDict :: Dictionary a
newDict = (Dictionary (arrayOf LinkedList.EmptyNode defaultSize) 0)
  where
    arrayOf :: a -> Int -> [a]
    arrayOf _ 0 = []
    arrayOf a i = a : arrayOf a (i - 1)

    defaultSize = 1024

set :: Dictionary a -> String -> a -> Dictionary a
set d k v = let updatedDict = setHelper d k v
            in
              -- after updating the dictionary, make sure we
              -- don't need to expand it (using saturation limit of 70%)
              if isSaturated updatedDict
              then updatedDict
              else updatedDict
  where
    bucketCount :: Dictionary a -> Int
    bucketCount (Dictionary b _) = length b

    saturationLimit :: Dictionary a -> Int
    saturationLimit d' = bucketCount d'

    isSaturated :: Dictionary a -> Bool
    isSaturated d'@(Dictionary _ s) = s > saturationLimit d'

    isBucketEmpty :: LinkedList.List (String, v) -> Bool
    isBucketEmpty (LinkedList.Node _ _) = True
    isBucketEmpty LinkedList.EmptyNode   = False

    matchingKey :: String -> (String, v) -> Bool
    matchingKey s p = s == fst p

    -- returns a new dictionary equivalent to the given one,
    -- except it has twice as many buckets
    expand :: Dictionary a -> Dictionary a
    expand d'@(Dictionary b' _) = let resized = (Dictionary (arrayOf LinkedList.EmptyNode $ 2 * length b') 0) :: Dictionary a
                                  in copy d' resized -- copy the existing dict into a new dict
                                                     -- with twice as many buckets
      where
        arrayOf :: a -> Int -> [a]
        arrayOf _ 0 = []
        arrayOf a i = a : arrayOf a (i - 1)

    setHelper :: Dictionary a -> String -> a -> Dictionary a
    setHelper (Dictionary b' s') k' v'
      | isBucketEmpty bucket  = (Dictionary (replaceElementAt b' index newNode) (s' + 1)) -- no collision
      | isJust keyMatchedNode = (Dictionary (replaceElementAt b' index $ updateValue bucket (k', v')) s') -- since it's an update, no size change
      | otherwise             = (Dictionary (replaceElementAt b' index $ LinkedList.append bucket (k', v')) (s' + 1)) -- add this node to the bucket and update size
        where
          index = hash k' `mod` length b'
          bucket = b' !! index

          keyMatchedNode = LinkedList.findNode (matchingKey k') bucket
          newNode = LinkedList.newNode (k', v')

          updateValue :: (LinkedList.List (String, a)) -> (String, a) -> (LinkedList.List (String, a))
          updateValue l p@(k'', _) = LinkedList.replaceWhere (matchingKey k'') p l

-- copy the contents of d into d'
copy :: Dictionary a -> Dictionary a -> Dictionary a
copy (Dictionary b _) d = foldl (\curr next -> copyListIntoDict curr next) d b
  where
    copyListIntoDict :: Dictionary a -> LinkedList.List (String, a) -> Dictionary a
    copyListIntoDict d' LinkedList.EmptyNode         = d'
    copyListIntoDict d' (LinkedList.Node (k, v) n) = set (copyListIntoDict d' n) k v

get :: Dictionary a -> String -> Maybe a
get (Dictionary b _) k
  | isJust keyMatchedNode = Just $ snd (fromJust keyMatchedNode)
  | otherwise = Nothing
  where
    index = hash k `mod` length b
    bucket = b !! index

    matchingKey :: String -> (String, v) -> Bool
    matchingKey s p = s == fst p

    keyMatchedNode = LinkedList.find (matchingKey k) bucket

containsKey :: Dictionary a -> String -> Bool
containsKey (Dictionary b _) k = isJust keyMatchedNode
  where
    index = hash k `mod` length b
    bucket = b !! index

    matchingKey :: String -> (String, v) -> Bool
    matchingKey s p = s == fst p

    keyMatchedNode = LinkedList.find (matchingKey k) bucket

keys :: Dictionary a -> [String]
keys (Dictionary b _) = foldl (\curr next -> curr ++ bucketKeys next) [] b
  where
    bucketKeys :: (LinkedList.List (String, a) -> [String])
    bucketKeys = (map fst) . LinkedList.toList

pairs :: Dictionary a -> [(String, a)]
pairs (Dictionary b _) = foldl (\curr next -> curr ++ LinkedList.toList next) [] b

toList :: Dictionary a -> [(String, a)]
toList (Dictionary b _) = foldl (++) [] (map (LinkedList.toList) b)
