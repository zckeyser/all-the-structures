module Math.SieveTest where

import Test.Framework
import Test.Framework.Providers.HUnit
import Test.HUnit ((@?=))

import qualified Math.Sieve as Sieve

sieveTest :: Test
sieveTest = testGroup "Eratosthenes' Sieve"
                      [ testCase "eratosthenes -1" $ Sieve.eratosthenes (-1) @?= []
                      , testCase "eratosthenes 2" $ Sieve.eratosthenes 2 @?= [2]
                      , testCase "eratosthenes 100" $ Sieve.eratosthenes 100 @?= [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97]
                      ]
