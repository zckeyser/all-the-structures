module Sort.InsertionSortTest where

import Test.Framework
import Test.Framework.Providers.HUnit
import Test.HUnit ((@?=))

import Sort.InsertionSort

insertionSortTest :: Test
insertionSortTest = testGroup "Insertion Sort"
                          [ testCase "insertionSort []" $ insertionSort ([] :: [Int]) @?= []
                          , testCase "insertionSort [1]" $ insertionSort ([1] :: [Int]) @?= [1]
                          , testCase "insertionSort [1, 2, 3]" $ insertionSort ([1, 2, 3] :: [Int]) @?= [1, 2, 3]
                          , testCase "insertionSort [3, 2, 1]" $ insertionSort ([3, 2, 1] :: [Int]) @?= [1, 2, 3]
                          , testCase "insertionSort [1, 7, 4, 6, 2, 3, 9, 5, 12]" $ insertionSort ([1, 7, 4, 6, 2, 3, 9, 5, 12] :: [Int]) @?= [1, 2, 3, 4, 5, 6, 7, 9, 12]
                          , testCase "insertionSort [2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4, 4, 4, 4, 4, 0]" $
                            insertionSort ([2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4, 4, 4, 4, 4, 0] :: [Int]) @?= [0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 4, 4, 4, 4, 4, 4]
                          ]
