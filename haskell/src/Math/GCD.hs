module Math.GCD where

-- euclidean algorithm for calculating gcd(a, b)
euclidean :: Integer -> Integer -> Integer
euclidean a b
  | a < b             = euclidean b a
  | a `mod` b == 0    = b
  | otherwise         = euclidean (a `mod` b) b
