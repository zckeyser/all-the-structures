module Main where

import Test.Framework
import Test.Framework.Providers.HUnit
import Test.HUnit ((@?=))

import Math.SieveTest
import Math.GCDTest

main :: IO ()
main = defaultMain tests

tests :: [Test]
tests = [harness, sieveTest, gcdTest]

harness :: Test
harness = testGroup "Harness Verification"
                    [testCase "true" $ 1 @?= 1]
