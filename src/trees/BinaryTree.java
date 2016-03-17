package trees;

/**
 * Created by Chris Keyser on 3/11/2016.
 * A generic binary tree implementation (not BST)
 */
public class BinaryTree<T> {
    private BinaryTree<T> left;
    private BinaryTree<T> right;
    private T val;

    public BinaryTree(T val) {
        this.val = val;
    }

    public BinaryTree getLeftChild() {
        return left;
    }

    public void setLeftChild(BinaryTree<T> left) {
        this.left = left;
    }

    public BinaryTree getRightChild() {
        return right;
    }

    public void setRightChild(BinaryTree<T> right) {
        this.right = right;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T newVal) {
        this.val = newVal;
    }

    /**
     * checks to see if the tree contains obj
     * inefficient because it cannot optimize like a BST, leading to O(n) efficiency
     */
    public boolean contains(T obj) {
        return obj.equals(val) ||
                (left != null && left.contains(obj)) ||
                (right != null && right.contains(obj));
    }
}
