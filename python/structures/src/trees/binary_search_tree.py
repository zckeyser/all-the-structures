class BinarySearchTree(object):
    def __init__(self, parent, value):
        self.parent = parent
        self.value = value
        self.left = None
        self.right = None

    # get maximum value from tree
    def max(self):
        curr = self

        while curr.right != None:
            curr = curr.right

        return curr.value

    # get minimum value from tree
    def min(self):
        curr = self

        while curr.left != None:
            curr = curr.left

        return curr.value

    def insert(self, value):
        if value < self.value:
            # left side insert
            if self.left == None:
                self.left = BinarySearchTree(self, value)
                return self.left
            else:
                return self.left.insert(value)
        else:
            # right side insert
            if self.right == None:
                self.right = BinarySearchTree(self, value)
                return self.right
            else:
                return self.right.insert(value)

    def hasSingleChild(self):
        # ^ is xor
        return (self.left != None) ^ (self.right != None)

    def isLeaf(self):
        return self.left == None and self.right == None

    def contains(self, value):
        return self._find(value) != None

    def _find(self, value):
        if self.value == value:
            return self
        elif value < self.value:
            if self.left != None:
                return self.left._find(value)
            else:
                return None
        else:
            if self.right != None:
                return self.right._find(value)
            else:
                return None

    def _replaceChild(self, child, newVal):
        if newVal != None:
            newVal.parent = self

        if self.left != None and child == self.left.value:
            self.left = newVal
        else:
            self.right = newVal

    def remove(self, value):
        if not self.contains(value):
            return

        if value < self.value:
            if self.left != None:
                self.left.remove(value)
        elif value > self.value:
            if self.right != None:
                self.right.remove(value)
        else:
            if self.isLeaf() and self.parent != None:
                # if this node is a leaf we can just remove it
                self.parent._replaceChild(self.value, None)
                return self.parent
            elif self.hasSingleChild() and self.Parent != None:
                # if we have a single child, replace this node with its child
                child = self.left if self.left != None else self.right
                self.parent._replaceChild(self.value, child)

                return child
            else:
                # this is the root or a node with two children,
                # either way replace it with either the max of the left subtree or the min of the right
                child = self._find(self.left.max()) if self.left != None else self._find(self.right.min())

                self.value = child.value

                child.remove(child.value)

                return self
