module Sort.BubbleSortTest where

import Test.Framework
import Test.Framework.Providers.HUnit
import Test.HUnit ((@?=))

import Sort.BubbleSort

bubbleSortTest :: Test
bubbleSortTest = testGroup "Bubble Sort"
                          [ testCase "bubbleSort []" $ bubbleSort ([] :: [Int]) @?= []
                          , testCase "bubbleSort [1]" $ bubbleSort ([1] :: [Int]) @?= [1]
                          , testCase "bubbleSort [1, 2, 3]" $ bubbleSort ([1, 2, 3] :: [Int]) @?= [1, 2, 3]
                          , testCase "bubbleSort [3, 2, 1]" $ bubbleSort ([3, 2, 1] :: [Int]) @?= [1, 2, 3]
                          , testCase "bubbleSort [1, 7, 4, 6, 2, 3, 9, 5, 12]" $ bubbleSort ([1, 7, 4, 6, 2, 3, 9, 5, 12] :: [Int]) @?= [1, 2, 3, 4, 5, 6, 7, 9, 12]
                          , testCase "bubbleSort [2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4, 4, 4, 4, 4, 0]" $
                            bubbleSort ([2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4, 4, 4, 4, 4, 0] :: [Int]) @?= [0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 4, 4, 4, 4, 4, 4]
                          ]
