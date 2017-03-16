module Sort.SelectionSort where

import Data.List

selectionSort :: Ord a => [a] -> [a]
selectionSort [] = []
selectionSort xs = let minElem = minimum xs
                   in minElem : selectionSort (delete minElem xs)
