module Core.LinkedListTest where

import Test.Framework
import Test.Framework.Providers.HUnit
import Test.HUnit ((@?=))

import Core.LinkedList

linkedListTest :: Test
linkedListTest = testGroup "Linked List"
                           [ testCase "newNode 1" $ newNode 1 @?= fromList [1]
                           , testCase "isEmpty ()" $ isEmpty (fromList []) @?= True
                           , testCase "isEmpty (1)" $ isEmpty (fromList [1]) @?= False
                           , testCase "any' isEven ()" $ any' isEven (fromList []) @?= False
                           , testCase "any' isEven (1 2)" $ any' isEven (fromList [1, 2]) @?= True
                           , testCase "any' isEven (1 3)" $ any' isEven (fromList [1, 3]) @?= False
                           , testCase "contains () 1" $ contains (fromList []) 1 @?= False
                           , testCase "contains (1) 1" $ contains (fromList [1]) 1 @?= True
                           , testCase "contains (3 2 1) 1" $ contains (fromList [3, 2, 1]) 1 @?= True
                           , testCase "contains (2) 1" $ contains (fromList [2]) 1 @?= False
                           , testCase "contains (4 3 2) 1" $ contains (fromList [4, 3, 2]) 1 @?= False
                           , testCase "find isEven ()" $ find isEven (fromList []) @?= Nothing
                           , testCase "find isEven (1 2 3 4)" $ find isEven (fromList [1, 2, 3, 4]) @?= Just 2
                           , testCase "find isEven (1 3 5 7)" $ find isEven (fromList [1, 3, 5, 7]) @?= Nothing
                           , testCase "findNode isEven ()" $ findNode isEven (fromList []) @?= Nothing
                           , testCase "findNode isEven (1 2 3 4)" $ findNode isEven (fromList [1, 2, 3, 4]) @?= Just (fromList [2, 3, 4])
                           , testCase "findNode isEven (1 3 5 7)" $ findNode isEven (fromList [1, 3, 5, 7]) @?= Nothing
                           , testCase "replaceWhere isEven 5 (1 2 3 4)" $ replaceWhere isEven 5 (fromList [1, 2, 3, 4]) @?= fromList [1, 5, 3, 4]
                           , testCase "replaceWhere isEven 5 (1 3 5 7)" $ replaceWhere isEven 5 (fromList [1, 3, 5, 7]) @?= fromList [1, 3, 5, 7]
                           , testCase "replaceWhere isEven 5 ()" $ replaceWhere isEven 5 (fromList []) @?= (fromList [])
                           , testCase "append () 1" $ append (fromList []) 1 @?= fromList [1]
                           , testCase "append (1) 2" $ append (fromList [1]) 2 @?= fromList [1, 2]
                           , testCase "append (1, 2) 3" $ append (fromList [1, 2]) 3 @?= fromList [1, 2, 3]
                           , testCase "fromList []" $ fromList [] @?= (EmptyNode :: List Int)
                           , testCase "fromList [1]" $ fromList [1] @?= (Node 1 EmptyNode)
                           , testCase "fromList [1, 2, 3]" $ fromList [1, 2, 3] @?= (Node 1 (Node 2 (Node 3 EmptyNode)))
                           , testCase "toList ()" $ toList (EmptyNode :: List Int) @?= []
                           , testCase "toList (1)" $ toList (Node 1 EmptyNode) @?= [1]
                           , testCase "toList (1, 2, 3)" $ toList (Node 1 (Node 2 (Node 3 EmptyNode))) @?= [1, 2, 3]
                           ]
    where
      isEven :: Int -> Bool
      isEven n = n `mod` 2 == 0
