module Main where

import Test.Framework
import Test.Framework.Providers.HUnit
import Test.HUnit ((@?=))

import Core.StackTest
import Core.QueueTest
import Dictionary.StringHashTest
import Dictionary.DictionaryTest
import Graph.DirectedGraphTest
import Graph.BreadthFirstSearchTest
import Graph.DepthFirstSearchTest
import Math.SieveTest
import Math.GCDTest
import Tree.BSTTest

main :: IO ()
main = defaultMain tests

tests :: [Test]
tests = [ harness
        , stackTest
        , queueTest
        , stringHashTest
        , dictionaryTest
        , directedGraphTest
        , bfsTest
        , dfsTest
        , sieveTest
        , gcdTest
        , bstTest
        ]

harness :: Test
harness = testGroup "Harness Verification"
                    [testCase "true" $ 1 @?= 1]
