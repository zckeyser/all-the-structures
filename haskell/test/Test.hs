module Main where

import Test.Framework
import Test.Framework.Providers.HUnit
import Test.HUnit ((@?=))

import Core.StackTest
import Core.QueueTest
import Graph.DirectedGraphTest
import Graph.BreadthFirstSearchTest
import Math.SieveTest
import Math.GCDTest

main :: IO ()
main = defaultMain tests

tests :: [Test]
tests = [ harness
        , stackTest
        , queueTest
        , directedGraphTest
        , bfsTest
        , sieveTest
        , gcdTest
        ]

harness :: Test
harness = testGroup "Harness Verification"
                    [testCase "true" $ 1 @?= 1]
