module Core.HelperTest where

import Test.Framework
import Test.Framework.Providers.HUnit
import Test.HUnit ((@?=))

import Core.Helper

helperTest :: Test
helperTest = testGroup "Helper Functions"
                       [ testCase "replaceElementAt [1, 2, 3, 4] 2 5" $ replaceElementAt [1, 2, 3, 4] 2 5 @?= [1, 2, 5, 4]
                       , testCase "replaceElementAt [1, 2, 3, 4] 5 5" $ replaceElementAt [1, 2, 3, 4] 5 5 @?= [1, 2, 3, 4]
                       , testCase "replaceElementAt [] 0 5" $ replaceElementAt [] 0 5 @?= []
                       ]
