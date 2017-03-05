module Graph.DirectedGraphTest where

import Test.Framework
import Test.Framework.Providers.HUnit
import Test.HUnit ((@?=))

import Graph.DirectedGraph as DirectedGraph

directedGraphTest :: Test
directedGraphTest = testGroup "Directed Graph"
                              [ testCase "Int node initialization" $ DirectedGraph.newNode 5 @?= (DirectedGraph.Node 5 [])
                              , testCase "String node initialization" $ DirectedGraph.newNode "foo" @?= (DirectedGraph.Node "foo" [])
                              , testCase "Add single neighbor" $ DirectedGraph.addNeighbor
                                                                              (DirectedGraph.Node 5 []) -- initial node
                                                                              (DirectedGraph.Node 10 []) -- neighbor to add
                                                                              @?=
                                                                              (DirectedGraph.Node 5 [(DirectedGraph.Node 10 [])])
                              , testCase "Add multiple neighbors" $ DirectedGraph.addNeighbor
                                                                                (DirectedGraph.addNeighbor
                                                                                  (DirectedGraph.Node 5 []) -- initial node
                                                                                  (DirectedGraph.Node 10 []) -- first neighbor to add
                                                                                )
                                                                                (DirectedGraph.Node 15 []) -- second neighbor to add
                                                                                @?=
                                                                                (DirectedGraph.Node 5 [(DirectedGraph.Node 15 []), (DirectedGraph.Node 10 [])])
                              , testCase "Remove neighbor" $ DirectedGraph.removeNeighbor
                                                                          (DirectedGraph.Node 5 [(DirectedGraph.Node 10 [])])
                                                                          10 -- remove neighbor with value 10
                                                                          @?=
                                                                          (DirectedGraph.Node 5 [])
                              ]
