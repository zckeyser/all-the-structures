module Dictionary.Dictionary where

import Data.Maybe
import Data.List

import Core.Helper
import Dictionary.StringHash

data Dictionary v = Dictionary{ buckets :: [[(String, v)]], size :: Int }

newDict :: Dictionary a
newDict = (Dictionary (arrayOf [] defaultSize) 0)
  where
    defaultSize = 1024

set :: Dictionary a -> String -> a -> Dictionary a
set d k v = let updatedDict = setHelper d k v
            in
              -- after updating the dictionary, make sure we
              -- don't need to expand it (using saturation limit of 70%)
              if isSaturated updatedDict
              then expand updatedDict
              else updatedDict
  where
    bucketCount :: Dictionary a -> Int
    bucketCount (Dictionary b _) = length b

    saturationLimit :: Dictionary a -> Int
    saturationLimit d' = bucketCount d'

    isSaturated :: Dictionary a -> Bool
    isSaturated d'@(Dictionary _ s) = s > saturationLimit d'

    matchingKey :: String -> (String, v) -> Bool
    matchingKey s p = s == fst p

    -- returns a new dictionary equivalent to the given one,
    -- except it has twice as many buckets
    expand :: Dictionary a -> Dictionary a
    expand d'@(Dictionary b' _) = let resized = (Dictionary (arrayOf [] $ 2 * length b') 0) :: Dictionary a
                                  in copy d' resized -- copy the existing dict into a new dict
                                                     -- with twice as many buckets

    setHelper :: Dictionary a -> String -> a -> Dictionary a
    setHelper (Dictionary b' s') k' v'
      | null bucket           = (Dictionary (replaceElementAt b' index [newPair]) (s' + 1)) -- no collision
      | isJust keyMatchedNode = (Dictionary (replaceElementAt b' index $ updateValue bucket newPair) s') -- since it's an update, no size change
      | otherwise             = (Dictionary (replaceElementAt b' index $ newPair : bucket) (s' + 1)) -- add this node to the bucket and update size
        where
          index = hash k' `mod` length b'
          bucket = b' !! index

          keyMatchedNode = find (matchingKey k') bucket
          newPair = (k', v')

          updateValue :: [(String, a)] -> (String, a) -> [(String, a)]
          updateValue [] _ = []
          updateValue (x:xs) p@(key, _)
            | key == fst x = p : xs
            | otherwise    = updateValue xs p

-- copy the contents of d into d'
copy :: Dictionary a -> Dictionary a -> Dictionary a
copy (Dictionary b _) d = foldl (\curr next -> copyListIntoDict curr next) d b
  where
    copyListIntoDict :: Dictionary a -> [(String, a)] -> Dictionary a
    copyListIntoDict d' xs = foldl (\curr next -> set curr (fst next) (snd next)) d' xs

get :: Dictionary a -> String -> Maybe a
get (Dictionary b _) k
  | isJust keyMatchedNode = Just $ snd (fromJust keyMatchedNode)
  | otherwise = Nothing
  where
    index = hash k `mod` length b
    bucket = b !! index

    matchingKey :: String -> (String, v) -> Bool
    matchingKey s p = s == fst p

    keyMatchedNode = find (matchingKey k) bucket

containsKey :: Dictionary a -> String -> Bool
containsKey (Dictionary b _) k = isJust keyMatchedNode
  where
    index = hash k `mod` length b
    bucket = b !! index

    matchingKey :: String -> (String, v) -> Bool
    matchingKey s p = s == fst p

    keyMatchedNode = find (matchingKey k) bucket

keys :: Dictionary a -> [String]
keys (Dictionary b _) = foldl (\curr next -> curr ++ bucketKeys next) [] b
  where
    bucketKeys :: ([(String, a)] -> [String])
    bucketKeys = map fst

toList :: Dictionary a -> [(String, a)]
toList (Dictionary b _) = foldl (++) [] b
