module Sort.QuicksortTest where

import Test.Framework
import Test.Framework.Providers.HUnit
import Test.HUnit ((@?=))

import Sort.Quicksort

quicksortTest :: Test
quicksortTest = testGroup "quicksort"
                          [ testCase "quicksort []" $ quicksort ([] :: [Int]) @?= []
                          , testCase "quicksort [1]" $ quicksort ([1] :: [Int]) @?= [1]
                          , testCase "quicksort [1, 2, 3]" $ quicksort ([1, 2, 3] :: [Int]) @?= [1, 2, 3]
                          , testCase "quicksort [3, 2, 1]" $ quicksort ([3, 2, 1] :: [Int]) @?= [1, 2, 3]
                          , testCase "quicksort [1, 7, 4, 6, 2, 3, 9, 5, 12]" $ quicksort ([1, 7, 4, 6, 2, 3, 9, 5, 12] :: [Int]) @?= [1, 2, 3, 4, 5, 6, 7, 9, 12]
                          , testCase "quicksort [2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4, 4, 4, 4, 4, 0]" $
                            quicksort ([2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4, 4, 4, 4, 4, 0] :: [Int]) @?= [0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 4, 4, 4, 4, 4, 4]
                          ]
