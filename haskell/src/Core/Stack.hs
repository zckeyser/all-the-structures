module Core.Stack where

type Stack a = [a]

-- Initialize a stack with the given value
newStack :: a -> Stack a
newStack x = [x]

-- push an item onto the top of the stack
push :: Stack a -> a -> Stack a
push s x  = x : s

-- pop an item off the top of the stack
-- returns both the item that was popped and the state of the
-- stack after popping
pop :: Stack a -> (a, Stack a)
pop s = (head s, tail s)
