import Queue
import Graph

module Graph.BreadthFirstSearch
( bfs
) where

-- breadth first traversal of a directed graph
-- makes the assumption that nodes with equal values are duplicates
-- so if multiple nodes with the same value are in
bfs :: (Eq a) => Node a -> [a]
bfs start = bfsHelper $ newQueue start

bfsHelper :: (Eq a) => (Queue (Node a))  -> [a] -> [a]
bfsHelper [] = []
bfsHelper q visited = let curr = dequeue q
                          currNode = fst curr
                          currQueue = snd curr
                          currValue = value currNode
                          currNeighors = neighbors currNode
                          notVisited = not . elem visited
                          notQueued = \x -> not . any (\n -> value n == x) q
                          isNew = \n -> notVisited $ value x && notQueued x
                          newNeighbors = filter isNew currNeighbors
                      in
