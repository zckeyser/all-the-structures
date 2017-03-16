module Sort.MergesortTest where

import Test.Framework
import Test.Framework.Providers.HUnit
import Test.HUnit ((@?=))

import Sort.Mergesort

mergesortTest :: Test
mergesortTest = testGroup "Merge Sort"
                          [ testCase "mergesort []" $ mergesort ([] :: [Int]) @?= []
                          , testCase "mergesort [1]" $ mergesort ([1] :: [Int]) @?= [1]
                          , testCase "mergesort [1, 2, 3]" $ mergesort ([1, 2, 3] :: [Int]) @?= [1, 2, 3]
                          , testCase "mergesort [3, 2, 1]" $ mergesort ([3, 2, 1] :: [Int]) @?= [1, 2, 3]
                          , testCase "mergesort [1, 7, 4, 6, 2, 3, 9, 5, 12]" $ mergesort ([1, 7, 4, 6, 2, 3, 9, 5, 12] :: [Int]) @?= [1, 2, 3, 4, 5, 6, 7, 9, 12]
                          , testCase "mergesort [2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4, 4, 4, 4, 4, 0]" $
                            mergesort ([2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4, 4, 4, 4, 4, 0] :: [Int]) @?= [0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 4, 4, 4, 4, 4, 4]
                          ]
