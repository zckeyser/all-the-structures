module Core.Helper where

replaceElementAt :: [a] -> Int -> a -> [a]
replaceElementAt [] n x' = []
replaceElementAt (x:xs) n x'
  | n == 0    = x' : xs
  | otherwise = x : replaceElementAt xs (n - 1) x'

-- create an array consisting of the given value repeated i times
arrayOf :: a -> Int -> [a]
arrayOf _ 0 = []
arrayOf a i = a : arrayOf a (i - 1)
