module Dictionary.DictionaryTest where

import Test.Framework
import Test.Framework.Providers.HUnit
import Test.HUnit ((@?=))

import qualified Dictionary.Dictionary as Dictionary
import qualified LinkedList as LinkedList

dictionaryTest :: Test
dictionaryTest = testGroup "Dictionary"
                            [ testCase "newDict bucket count" $ length . buckets newDict @?= 1024
                            , testCase "newDict bucket contents" $ all LinkedList.isEmpty $ buckets newDict @?= True
                            , testCase "newDict size" $ size newDict @?= 0
                            , testCase "set and get single value" $ get (set newDict "foo" 1) "foo" @?= Just 1
                            , testCase "set and get bad key" $ get (set newDict "foo" 1) "bar" @?= Nothing
                            ]
  where
    newDict = Dictionary.newDict :: Dictionary Int
