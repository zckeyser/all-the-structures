module Graph.DepthFirstSearchTest where

import Test.Framework
import Test.Framework.Providers.HUnit
import Test.HUnit ((@?=))

import qualified Graph.ExampleGraph as Example
import qualified Graph.DepthFirstSearch as DFS

dfsTest :: Test
dfsTest = testGroup "Depth-First Search"
                    [testCase "" $ DFS.dfs Example.graph @?= [21, 39, 27, 30, 33, 36, 16, 11, 84, 18, 63, 14, 51]]
