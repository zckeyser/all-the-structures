module Dictionary.StringHash where

import Data.Char

hash :: String -> Int
hash s = hashHelper s 1
  where
    hashHelper :: String -> Int -> Int
    hashHelper "" _     = 0
    hashHelper (x:xs) n = ord x * n + hashHelper xs (n + 1)
