package tree

type BinarySearchTree struct {
  val int
  count int
  left *BinarySearchTree
  right *BinarySearchTree
}

func NewBST(val int) *BinarySearchTree {
  t := new(BinarySearchTree)
  t.val = val
  t.count = 1
  return t
}

func (t *BinarySearchTree) Insert(val int) {
  newNode := NewBST(val)

  if val == t.val {
    t.count++
  } else if val < t.val {
    if t.left != nil {
      t.left.Insert(val)
    } else {
      t.left = newNode
    }
  } else {
    if t.right != nil {
      t.right.Insert(val)
    } else {
      t.right = newNode
    }
  }
}

// remove the node with the given value
func (t *BinarySearchTree) Remove(val int) {
  // allows for nulling the reference to the child if
  // it's the thing to be deleted
  if t.removeChildNode(val) { return }

  if val < t.val && t.left != nil {
    left.Remove(val)
  } else if val > t.val && t.right != nil {
    right.Remove(val)
  } else if t.count > 1 {
    t.count--
  } else {
    
  }
}

func (t *BinarySearchTree) leftMax() {

}

// delete the current node
func (t *BinarySearchTree) deleteChild(val int) {

}
