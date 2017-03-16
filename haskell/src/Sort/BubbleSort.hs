module Sort.BubbleSort where

import Core.Helper

bubbleSort :: Ord a => [a] -> [a]
bubbleSort xs
  | isSorted xs = xs
  | otherwise   = bubbleSort $ iter xs -- iterate through xs for swaps again
  where
    isSorted :: Ord a => [a] -> Bool
    isSorted [] = True
    isSorted [x] = True
    isSorted (x:y:xs)
      | x > y     = False
      | otherwise = isSorted $ y:xs

    iter :: Ord a => [a] -> [a]
    iter []  = []
    iter [x] = [x]
    iter (x:y:ys)
      | x < y = x:(iter $ y:ys)
      | otherwise = y:(iter $ x:ys)
