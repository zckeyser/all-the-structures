package trees;

/**
 * Created by Chris Keyser on 3/24/2016.
 * Standard generic binary tree implementation
 *
 * Currently this implementation has dangerous behavior (deletes entire sub-tree) in delete() because I'm not sure how to
 * safely handle node deletion in a standard binary tree
 */
public class BinaryTree<E> {
    private BinaryTree<E> left, right, parent;
    private E data;

    public BinaryTree(E data, BinaryTree<E> parent) {
        this.left = null;
        this.right = null;
        this.parent = parent;
        this.data = data;
    }

    /**
     * returns true if this tree contains obj
     * has O(n) efficiency
     */
    public boolean contains(E obj) {
        return data.equals(obj) ||
               (left != null && left.contains(obj)) || (right != null && right.contains(obj));
    }

    public void setLeftChild(BinaryTree<E> node) {
        this.left = node;
    }

    public void setRightChild(BinaryTree<E> node) {
        this.right = node;
    }

    /**
     * delete node with value obj from tree
     * WARNING: this currently deletes the entire subtree starting at that node
     * because this is a general Binary Tree so there isn't defined behavior to shuffle the nodes to handle
     * replacing a node with two children
     * for a better, safer algorithm see BST removal @ BinarySearchTree:93
     */
    public void delete(E obj) {
        //ensure the object is in the tree before trying to delete it
        if(!contains(obj)) {
            return;
        }

        BinaryTree<E> node = this;

        //find node containing obj
        while(!node.data.equals(obj)) {
            if(left != null && left.contains(obj)) {
                node = left;
            } else if(right != null && right.contains(obj)) {
                node = right;
            }
        }
        
        //determines if the node to delete is its parent's left child
        boolean isLeftChild = node.parent.left.data.equals(obj);

        //delete node
        if(isLeftChild) {
            node.parent.left = null;
        } else {
            node.parent.right = null;
        }
    }

    private boolean isLeaf() {
        return left == null && right == null;
    }

    private boolean hasSingleChild() {
        // ^ is XOR (exclusive or) operator, which is equivalent to (left != null || right != null) && !(left != null & right != null)
        return left != null ^ right != null;
    }
}
