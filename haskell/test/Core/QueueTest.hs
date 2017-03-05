module Core.QueueTest where

import Test.Framework
import Test.Framework.Providers.HUnit
import Test.HUnit ((@?=))

import qualified Core.Queue as Queue

queueTest :: Test
queueTest = testGroup "Queue"
                      [ testCase "Int initialization" $ Queue.newQueue 5 @?= [5]
                      , testCase "String initialization" $ Queue.newQueue "foo" @?= ["foo"]
                      , testCase "(Queue Int) initialization" $ Queue.newQueue (Queue.newQueue 5) @?= [[5]]
                      , testCase "Single enqueue" $ Queue.enqueue [5] 10 @?= [5, 10]
                      , testCase "Single dequeue" $ Queue.dequeue [15, 10, 5] @?= (15, [10, 5])
                      , testCase "Multi enqueue" $ Queue.enqueue (Queue.enqueue [] 5) 10 @?= [5, 10]
                      -- I'll do multi dequeue once I figure out how to make this stuff monadic
                      -- since doing that kind of composition without it will be pretty messy
                      ]
