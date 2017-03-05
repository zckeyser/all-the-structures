module Core.StackTest where

import Test.Framework
import Test.Framework.Providers.HUnit
import Test.HUnit ((@?=))

import qualified Core.Stack as Stack

stackTest :: Test
stackTest = testGroup "Stack"
                      [ testCase "Int initialization" $ Stack.newStack 5 @?= [5]
                      , testCase "String initialization" $ Stack.newStack "foo" @?= ["foo"]
                      , testCase "(Stack Int) initialization" $ Stack.newStack (Stack.newStack 5) @?= [[5]]
                      , testCase "Single push" $ Stack.push [5] 10 @?= [10, 5]
                      , testCase "Single pop" $ Stack.pop [15, 10, 5] @?= (15, [10, 5])
                      , testCase "Multi push" $ Stack.push (Stack.push [] 5) 10 @?= [10, 5]
                      -- I'll do multi pop once I figure out how to make this stuff monadic
                      -- since doing that kind of composition without it will be pretty messy
                      ]
