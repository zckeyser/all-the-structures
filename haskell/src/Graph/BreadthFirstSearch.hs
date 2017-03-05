module Graph.BreadthFirstSearch (bfs) where

import Data.List

import Core.Queue
import Graph.DirectedGraph

-- breadth first traversal of a directed graph
bfs :: (Eq a) => Node a -> [a]
bfs start = bfsHelper [start] []

doesNotContain :: (Eq a) => [a] -> a -> Bool
doesNotContain l x = not $ elem x l

isNew :: (Eq a) => Queue (Node a) -> [Node a] -> Node a -> Bool
isNew q visited n = and [doesNotContain q n, doesNotContain visited n]

bfsHelper :: (Eq a) => Queue (Node a) -> [Node a] -> [a]
bfsHelper [] _ = []
bfsHelper q visited = let curr = dequeue q -- get the next node
                          currNode = fst curr
                          currQueue = snd curr
                          currValue = value currNode
                          currNeighbors = neighbors currNode -- get the neighbors of the current node
                          newNeighbors = filter (isNew q visited) currNeighbors -- filter neighbors to ones that aren't enqueued or visited
                          newQueue = currQueue ++ newNeighbors -- updated queue for next iteration
                          newVisited = currNode : visited
                      in
                          currValue : (bfsHelper newQueue newVisited) -- recurse on the rest of the queue with updated visited list
