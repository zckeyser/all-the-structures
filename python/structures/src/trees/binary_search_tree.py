class BinarySearchTree(object):
    def __init__(self, parent, value):
        self.parent = parent
        self.value = value
        self.left = None
        self.right = None

    # get maximum value from tree
    def __max__(self):
        curr = self

        while curr.right != None:
            curr = curr.right

        return curr.value

    # get minimum value from tree
    def __min__(self):
        curr = self

        while curr.left != None:
            curr = curr.left

        return curr.value

    def insert(self, value):
        if value < self.value:
            # left side insert
            if left == None:
                left = BinarySearchTree(self, value)
            else
                left.insert(value)
        else:
            # right side insert
            if right == None:
                right = BinarySearchTree(self, value)
            else
                right.insert(value)

    def hasSingleChild(self):
        # ^ is xor
        return self.left != None ^ self.right != None

    def isLeaf(self):
        return self.left == None and self.right == None

    def contains(self, value):
        if self.value == value:
            return True
        elif value < self.value:
            return left != None and left.contains(value)
        else
            return right != None and right.contains(value)

    def _find(self, value):
        if self.value == value:
            return True
        elif value < self.value:
            if left != None:
                return left._find(value)
            else:
                return None
        else:
            if right != None:
                return right._find(value)
            else:
                return None

    def _replaceChild(self, child, newVal):
        if newVal != None:
            newVal.parent = self

        if child == self.left.value:
            self.left = newVal
        else:
            self.right = newVal

    def remove(self, value):
        if not self.contains(value):
            return

        if value < self.value:
            if self.left != None:
                left.delete(value)
        elif value > self.value:
            if self.right != None:
                right.delete(value)
        else:
            if self.isLeaf() and self.parent != None:
                # if this node is a leaf we can just remove it
                self.parent._replaceChild(self.value, None)
            elif self.hasSingleChild() and self.Parent != None:
                # if we have a single child, replace this node with its child
                child = self.left if self.left != None else self.right
                self.parent._replaceChild(self.value, child)
            else:
                # this is the root or a node with two children,
                # either way replace it with either the max of the left subtree or the min of the right
                child = self._find(max(self.left)) if left != None else self._find(min(self.right))

                self.value = child.value

                child.remove(child.value)
