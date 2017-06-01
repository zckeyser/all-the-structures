package tree

type BinaryTree struct {
  left *BinaryTree
  right *BinaryTree
  value interface{}
}

// preorder walk of the binary tree
func (b *BinaryTree) Walk() []interface{} {
  var left, right []interface{}

  if b.left != nil {
    left = b.left.Walk()
  }

  if b.right != nil {
    right = b.right.Walk()
  }

  return append(append(left, b.value), right...)
}
