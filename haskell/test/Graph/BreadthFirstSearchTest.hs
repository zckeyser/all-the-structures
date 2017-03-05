module Graph.BreadthFirstSearchTest where

import Test.Framework
import Test.Framework.Providers.HUnit
import Test.HUnit ((@?=))

import qualified Graph.ExampleGraph as Example
import qualified Graph.BreadthFirstSearch as BFS

bfsTest :: Test
bfsTest = testGroup "Breadth-First Search"
                    [testCase "" $ BFS.bfs Example.graph @?= [21, 14, 18, 39, 51, 63, 16, 27, 84, 11, 30, 33, 36]]
