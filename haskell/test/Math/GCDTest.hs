module Math.GCDTest where

import Test.Framework
import Test.Framework.Providers.HUnit
import Test.HUnit ((@?=))

import qualified Math.GCD as GCD

gcdTest :: Test
gcdTest = testGroup "Euclidean Algorithm (GCD)"
                    [ testCase "gcd 24 36" $ GCD.euclidean 24 36 @?= 12
                    , testCase "gcd 374 8" $ GCD.euclidean 374 8 @?= 2
                    , testCase "gcd 7 31" $ GCD.euclidean 7 31 @?= 1
                    ]
