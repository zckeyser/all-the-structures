import Core.Queue
import Graph.DirectedGraph

module Graph.BreadthFirstSearch
  ( bfs
  ) where

-- breadth first traversal of a directed graph
-- makes the assumption that nodes with equal values are duplicates
-- so if multiple nodes with the same value are in
bfs :: (Eq a) => Node a -> [a]
bfs start = bfsHelper $ newQueue [value start]

bfsHelper :: (Eq a) => (Queue (Node a))  -> [a] -> [a]
bfsHelper [] = []
bfsHelper q visited = let curr = dequeue q -- get the next node
                          currNode = fst curr
                          currQueue = snd curr
                          currValue = value currNode
                          currNeighors = neighbors currNode -- get the neighbors of the current node
                          notVisited = not . elem visited
                          notQueued = \x -> not . any (\n -> value n == x) q
                          isNew = \n -> notVisited $ value x && notQueued x
                          newNeighbors = filter isNew currNeighbors -- filter neighbors to ones that aren't enqueued or visited
                      in
                          currValue : (bfsHelper $ enqueueList q newNeighbors $ currValue : visited) -- recurse on the rest of the queue with updated visited list

enqueueList :: (Queue a) -> [a] -> (Queue a)
enqueueList q [] = q
enqueueList q (x:xs) = enqueueList (enqueue q x) xs
