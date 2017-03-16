module Dictionary.DictionaryTest where

import System.Random
import System.IO.Unsafe
import Data.List

import Test.Framework
import Test.Framework.Providers.HUnit
import Test.HUnit ((@?=))

import qualified Dictionary.Dictionary as Dictionary
import Dictionary.StringHash

dictionaryTest :: Test
dictionaryTest = testGroup "Dictionary"
                            [ testCase "newDict bucket count" $ length (Dictionary.buckets newDict) @?= 1024
                            , testCase "newDict bucket contents" $ all null (Dictionary.buckets newDict) @?= True
                            , testCase "newDict size" $ Dictionary.size newDict @?= 0
                            , testCase "set and get single value" $ (Dictionary.get (Dictionary.set newDict "foo" 1) "foo") @?= Just 1
                            , testCase "set and get bad key" $ Dictionary.get (Dictionary.set newDict "foo" 1) "bar" @?= Nothing
                            , testCase "copy" $ allMatching (Dictionary.copy dict newDict) (Dictionary.toList dict) @?= True
                            , testCase "expand" $ allMatching dict pairs @?= True
                            ]
  where
    newDict = Dictionary.newDict :: Dictionary.Dictionary Int

    size = 2000

    inserted = insertN Dictionary.newDict size -- insert enough to trigger an expansion
    dict = fst inserted
    pairs = snd inserted-- all the key-value pairs that were inserted

    allMatching :: Dictionary.Dictionary Int -> [(String, Int)] -> Bool
    allMatching d []      = True -- if we got this far, everything matched
    allMatching d ((k, v):xs)
      | Dictionary.get d k == Just v = allMatching d xs
      | otherwise         = False

    genKeyFromInt :: Int -> String
    genKeyFromInt 1 = ""
    genKeyFromInt n = genKeyFromInt (n `div` 2) ++ show (n * 3)

    -- insert n values into a dictionary based on random strings
    -- returns the updated dict and the key value pairs used
    insertN :: Dictionary.Dictionary Int -> Int -> (Dictionary.Dictionary Int, [(String, Int)])
    insertN d 0 = (d, [])
    insertN d n = let s' = show n
                      updated = insertN (Dictionary.set d s' n) (n - 1)
                  in
                     (fst updated, (s', n) : snd updated)
