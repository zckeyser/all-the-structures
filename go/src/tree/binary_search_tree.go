package tree

type BinarySearchTree struct {
  val int
  count int
  left *BinarySearchTree
  right *BinarySearchTree
  parent *BinarySearchTree
}

// func NewBST(val int, parent *BinarySearchTree) *BinarySearchTree {
//   t := new(BinarySearchTree)
//   t.val = val
//   t.parent = parent
//   t.count = 1
//   return t
// }

// func (t *BinarySearchTree) Insert(val int) {
//   newNode := NewBST(val, t)

//   if val == t.val {
//     t.count++
//   } else if val < t.val {
//     if t.left != nil {
//       t.left.Insert(val)
//     } else {
//       t.left = newNode
//     }
//   } else {
//     if t.right != nil {
//       t.right.Insert(val)
//     } else {
//       t.right = newNode
//     }
//   }
// }

// // remove the node with the given value
// func (t *BinarySearchTree) Remove(val int) {
//   // allows for nulling the reference to the child if
//   // it's the thing to be deleted
//   if t.removeChildNode(val) { return }

//   if val < t.val && t.left != nil {
//     t.left.Remove(val)
//   } else if val > t.val && t.right != nil {
//     t.right.Remove(val)
//   } else if t.count > 1 {
//     t.count--
//   } else {
//     // actually remove the node
//     // if it has a left node, replace it with the rightmost descendant of the left node
    
// 	if t.left != nil || t.right != nil {
// 		replacement = t.left != nil ? t.left.max() : t.right.min()

// 		t.hardDelete(replacement)
// 		t.val = replacement.val
// 		t.count = replacement.count 
// 	} else {
// 		// the node's a leaf, just remove it directly
// 		if t.parent.val > t.val {
// 			t.parent.right = nil
// 		} else {
// 			t.parent.left = nil
// 		}
// 	}
//   }
// }

// func (t *BinarySearchTree) hardDelete(val int) {
// 	if t.val
// }

// func (t *BinarySearchTree) max() *BinarySearchTree {
// 	if t.right != nil {
// 		return t.right.max()
// 	} else {
// 		return t
// 	}
// }

// func (t *BinarySearchTree) min() *BinarySearchTree {
// 	if t.left != nil {
// 		return t.left.max()
// 	} else {
// 		return t
// 	}
// }
