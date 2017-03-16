module Sort.SortTest where

import Test.Framework
import Test.Framework.Providers.HUnit
import Test.HUnit ((@?=))

import Sort.BubbleSortTest
import Sort.InsertionSortTest
import Sort.SelectionSortTest
import Sort.QuicksortTest
import Sort.MergesortTest

sortTests :: [Test]
sortTests = [ bubbleSortTest
            , insertionSortTest
            , selectionSortTest
            , quicksortTest
            , mergesortTest
            ]
