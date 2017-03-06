module Tree.BST (Tree, singleton, insert, delete, contains, height) where

data Tree a = EmptyTree | Node { value :: a, left :: Tree a, right :: Tree a, count :: Int } deriving (Show, Read, Eq)

singleton :: (Ord a) => a -> Tree a
singleton x = (Node x EmptyTree EmptyTree 1)

contains :: (Ord a) => Tree a -> a -> Bool
contains EmptyTree _ = False
contains (Node v l r _) x
  | x > v          = contains r x
  | x < v          = contains l x
  | otherwise      = True

height :: Tree a -> Int
height EmptyTree      = 0
height (Node _ l r _) = 1 + max (height l) (height r)

insert :: (Ord a) => Tree a -> a -> Tree a
insert EmptyTree x = singleton x
insert (Node v l r c) x
    | x < v     = if l == EmptyTree
                  then (Node v (singleton x) r c)
                  else (Node v (insert l x) r c)
    | x > v     = if r == EmptyTree
                  then (Node v l (singleton x) c)
                  else (Node v l (insert r x) c)
    | otherwise = (Node v l r (c + 1))

delete :: (Ord a) => Tree a -> a -> Tree a
delete (t@(Node v l r c)) x
    | x < v           = if l /= EmptyTree
                        then (Node v (delete l x) r c)
                        else t
    | x > v           = if r /= EmptyTree
                        then (Node v l (delete r x) c)
                        else t
    | c > 1           = (Node v l r (c - 1))
    | l /= EmptyTree  = let sub = rightmost $ l -- replace with the rightmost node of the left subtree
                            newLeft = hardDelete l (value sub)
                        in (Node (value sub) newLeft r (count sub))
    | r /= EmptyTree  = let sub = leftmost $ r -- replace with the leftmost node of the right subtree
                            newRight = hardDelete r (value sub)
                        in (Node (value sub) l newRight (count sub))
    | otherwise       = EmptyTree -- delete this node entirely

-- delete a node regardless of its count, for internal use
hardDelete :: (Ord a) => Tree a -> a -> Tree a
hardDelete (t@(Node v l r c)) x
    | x < v           = if l /= EmptyTree
                        then (Node v (hardDelete l x) r c)
                        else t
    | x > v           = if r /= EmptyTree
                        then (Node v l (hardDelete r x) c)
                        else t
    | l /= EmptyTree  = let sub = rightmost $ l -- replace with the rightmost node of the left subtree
                            newLeft = hardDelete l (value sub)
                        in (Node (value sub) newLeft r (count sub))
    | r /= EmptyTree  = let sub = leftmost $ r -- replace with the leftmost node of the right subtree
                            newRight = hardDelete r (value sub)
                        in (Node (value sub) l newRight (count sub))
    | otherwise       = EmptyTree -- delete this node entirely

leaf :: Tree a -> Bool
leaf (Node _ EmptyTree EmptyTree _) = True
leaf _                              = False

singleChild :: Tree a -> Bool
singleChild EmptyTree                            = False
singleChild (Node _ EmptyTree (Node _ _ _ _) _)  = True
singleChild (Node _ (Node _ _ _ _ ) EmptyTree _) = True
singleChild _                                    = False

-- returns the rightmost node of the tree
rightmost :: Tree a -> Tree a
rightmost EmptyTree                  = EmptyTree
rightmost (t@(Node _ _ EmptyTree _)) = t
rightmost (Node _ _ r _)             = rightmost r

-- returns the leftmost node of the tree
leftmost :: Tree a -> Tree a
leftmost EmptyTree                  = EmptyTree
leftmost (t@(Node _ EmptyTree _ _)) = t
leftmost (Node _ l _ _)             = l
