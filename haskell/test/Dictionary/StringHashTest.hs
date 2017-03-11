module Dictionary.StringHashTest where

import Test.Framework
import Test.Framework.Providers.HUnit
import Test.HUnit ((@?=))

import Dictionary.StringHash

stringHashTest :: Test
stringHashTest = testGroup "String Hashing"
                            [ testCase "hash foo" $ hash "foo" @?= 657
                            , testCase "hash bar" $ hash "bar" @?= 634
                            , testCase "hash fizzbuzz" $ hash "fizzbuzz" @?= 4188
                            ]
