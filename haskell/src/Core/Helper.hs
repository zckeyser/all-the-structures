module Core.Helper where

replaceElementAt :: [a] -> Int -> a -> [a]
replaceElementAt [] n x' = []
replaceElementAt (x:xs) n x'
  | n == 0    = x' : xs
  | otherwise = x : replaceElementAt xs (n - 1) x'
