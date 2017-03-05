module Queue
( Queue
, newQueue
, enqueue
, dequeue
) where

type Queue a = [a]

-- Initialize a queue with the given value
newQueue :: a -> Queue a
newQueue x = [x]

-- enqueue an item into the back of the queue
enqueue :: Queue a -> a -> Queue a
enqueue s x  = s ++ [x]

-- dequeue an item from the front of the queue
-- returns both the dequeued item and the new state of the queue
dequeue :: Queue a -> (a, Queue a)
dequeue s = (head s, tail s)
