module Sort.Mergesort where

import Data.List

mergesort :: Ord a => [a] -> [a]
mergesort [] = []
mergesort [x] = [x]
mergesort xs = merge left right -- merge sorted sublists
  where
    -- split into two lists and recursively sort them
    midpoint = length xs `div` 2
    splitLists = splitAt midpoint xs

    left = mergesort $ fst splitLists
    right = mergesort $ snd splitLists

merge :: Ord a => [a] -> [a] -> [a]
merge xs [] = xs
merge [] ys = ys
merge xxs@(x:xs) yys@(y:ys)
  | x < y     = x : (merge xs yys) -- merge left tail with entire right
  | otherwise = y : (merge xxs ys) -- merge right tail with entire left
