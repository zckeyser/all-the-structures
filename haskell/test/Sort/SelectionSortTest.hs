module Sort.SelectionSortTest where

import Test.Framework
import Test.Framework.Providers.HUnit
import Test.HUnit ((@?=))

import Sort.SelectionSort

selectionSortTest :: Test
selectionSortTest = testGroup "Selection Sort"
                          [ testCase "selectionSort []" $ selectionSort ([] :: [Int]) @?= []
                          , testCase "selectionSort [1]" $ selectionSort ([1] :: [Int]) @?= [1]
                          , testCase "selectionSort [1, 2, 3]" $ selectionSort ([1, 2, 3] :: [Int]) @?= [1, 2, 3]
                          , testCase "selectionSort [3, 2, 1]" $ selectionSort ([3, 2, 1] :: [Int]) @?= [1, 2, 3]
                          , testCase "selectionSort [1, 7, 4, 6, 2, 3, 9, 5, 12]" $ selectionSort ([1, 7, 4, 6, 2, 3, 9, 5, 12] :: [Int]) @?= [1, 2, 3, 4, 5, 6, 7, 9, 12]
                          , testCase "selectionSort [2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4, 4, 4, 4, 4, 0]" $
                            selectionSort ([2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4, 4, 4, 4, 4, 0] :: [Int]) @?= [0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 4, 4, 4, 4, 4, 4]
                          ]
