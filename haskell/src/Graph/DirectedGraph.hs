module Graph.DirectedGraph where

data Node a = Node { value :: a, neighbors :: [Node a] } deriving (Eq, Show, Read)

newNode :: (Eq a) => a -> Node a
newNode x = (Node x [])

addNeighbor :: (Eq a) => Node a -> Node a -> Node a
addNeighbor n neighbor = (Node (value n) $ neighbor : neighbors n)

-- remove neighbors with value x from the given node's neighbors
removeNeighbor :: (Eq a) => Node a -> a -> Node a
removeNeighbor n x = (Node (value n) $ filter (\node -> value node /= x) (neighbors n))
