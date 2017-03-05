module Graph.ExampleGraph (graph) where

import qualified Graph.DirectedGraph as G

graph :: G.Node Int
graph = let
          n4  = (G.Node 51 [])
          n8  = (G.Node 84 [])
          n11 = (G.Node 36 [])
          n12 = (G.Node 11 [])
          n10 = (G.Node 33 [n11])
          n9  = (G.Node 30 [n10])
          n7  = (G.Node 27 [n9])
          n6  = (G.Node 16 [n8, n12])
          n5  = (G.Node 63 [n8])
          n1  = (G.Node 14 [n4])
          n3  = (G.Node 39 [n6, n7])
          n2  = (G.Node 18 [n1, n5])
        in      (G.Node 21 [n1, n2, n3])
