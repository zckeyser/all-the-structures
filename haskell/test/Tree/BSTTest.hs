module Tree.BSTTest where

import Test.Framework
import Test.Framework.Providers.HUnit
import Test.HUnit ((@?=))

import Tree.BST as BST
import Tree.Traversal as Traversal

bstTest :: Test
bstTest = let -- this will be better if I convert the project to be monadic
            t1 = BST.singleton 50
            t2 = BST.insert t1 10
            t3 = BST.insert t2 30
            t4 = BST.insert t3 42
            t5 = BST.insert t4 15
            t6 = BST.insert t5 3
            t7 = BST.insert t6 60
            t8 = BST.insert t7 80
            t9 = BST.insert t8 83
            t10 = BST.insert t9 24
            t11 = BST.insert t10 73
            t12 = BST.insert t11 87
            t = BST.insert t12 100 -- finalized initial tree
          in
          testGroup "BST"
                    [ testCase "Insert" $ Traversal.inorder t @?= [3, 10, 15, 24, 30, 42, 50, 60, 73, 80, 83, 87, 100]
                    , testCase "Remove leaf" $ Traversal.inorder $ delete t 3 @?= [10, 15, 24, 30, 42, 50, 60, 73, 80, 83, 87, 100]
                    , testCase "Remove node with single child" $ Traversal.inorder $ delete t 10 @?= [3, 15, 24, 30, 42, 50, 60, 73, 80, 83, 87, 100]
                    , testCase "Remove node with two children" $ Traversal.inorder $ delete t 30 @?= [3, 10, 15, 24, 42, 50, 60, 73, 80, 83, 87, 100]
                    , testCase "Remove root" $ Traversal.inorder $ delete t 50 @?= [3, 10, 15, 24, 30, 42, 60, 73, 80, 83, 87, 100]
                    , testCase "Contains positive" $ BST.contains t 24 @?= True
                    , testCase "Contains negative" $ BST.contains t 25 @?= False
                    ]
