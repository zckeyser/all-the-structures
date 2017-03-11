module StringHash where

import Data.Char

hash :: String -> Integer
hash s = hashHelper s 1
  where
    hashHelper :: String -> Integer -> Integer
    hashHelper "" _     = 0
    hashHelper (x:xs) n = ord x * n + hashHelper xs (n + 1) 
