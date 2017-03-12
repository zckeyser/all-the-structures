module Dictionary.DictionaryTest where

import Test.Framework
import Test.Framework.Providers.HUnit
import Test.HUnit ((@?=))

import qualified Dictionary.Dictionary as Dictionary
import qualified LinkedList.LinkedList as LinkedList

dictionaryTest :: Test
dictionaryTest = testGroup "Dictionary"
                            [ testCase "newDict bucket count" $ length (Dictionary.buckets newDict) @?= 1024
                            , testCase "newDict bucket contents" $ all LinkedList.isEmpty (Dictionary.buckets newDict) @?= True
                            , testCase "newDict size" $ Dictionary.size newDict @?= 0
                            , testCase "set and get single value" $ Dictionary.get (Dictionary.set newDict "foo" 1) "foo" @?= Just 1
                            , testCase "set and get bad key" $ Dictionary.get (Dictionary.set newDict "foo" 1) "bar" @?= Nothing
                            ]
  where
    newDict = Dictionary.newDict :: Dictionary.Dictionary Int
