module Math.GCD (
  gcd
) where

-- euclidean algorithm for calculating gcd(a, b)
gcd :: Integer -> Integer -> Integer
gcd a b
  | a < b        = gcd b a
  | a `mod` b    = b
  | otherwise    = gcd $ a `mod` b $ b
