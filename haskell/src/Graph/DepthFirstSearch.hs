module Graph.DepthFirstSearch (dfs) where

import Data.List

import Core.Stack
import Graph.DirectedGraph

-- breadth first traversal of a directed graph
dfs :: (Eq a) => Node a -> [a]
dfs start = dfsHelper [start] []

doesNotContain :: (Eq a) => [a] -> a -> Bool
doesNotContain l x = not $ x `elem` l

isNew :: (Eq a) => Stack (Node a) -> [Node a] -> Node a -> Bool
isNew q visited n = and [doesNotContain q n, doesNotContain visited n]

dfsHelper :: (Eq a) => Stack (Node a) -> [Node a] -> [a]
dfsHelper [] _ = []
dfsHelper q visited = let curr = pop q -- get the next node
                          currNode = fst curr
                          currStack = snd curr
                          currValue = value currNode
                          currNeighbors = neighbors currNode -- get the neighbors of the current node
                          newNeighbors = filter (isNew q visited) currNeighbors -- filter neighbors to ones that aren't enqueued or visited
                          newStack = (reverse newNeighbors) ++ currStack  -- updated stack for next iteration
                          newVisited = currNode : visited
                      in
                          currValue : (dfsHelper newStack newVisited) -- recurse on the rest of the queue with updated visited list
