package trees;

/**
 * Created by Chris Keyser on 3/11/2016.
 * Binary search tree implementation
 * Includes support for insertion, deletion, contains, height, and pre-order/in-order/post-order traversals
 */
public class BinarySearchTree {
    private BinarySearchTree left;
    private BinarySearchTree right;
    private BinarySearchTree parent;
    private int val;

    public BinarySearchTree(BinarySearchTree parent, int val) {
        this.val = val;
        this.parent = parent;
        left = null;
        right = null;
    }

    public int getVal() {
        return val;
    }

    /**
     * Inserts a value into the BST
     * @param i value to insert into the BST
     */
    public void insert(int i) {
        // if newVal is less than val, it should be added to the left side of the tree, otherwise add it to the right side
        if(i < val) {
            if(left == null) {
                //if there is no left child, create a new left child with newVal
                left = new BinarySearchTree(this, i);
            } else {
                // if there is a left child, add newVal to the tree on the left
                left.insert(i);
            }
        } else {
            if(right == null) {
                //if there is no right child, create a new right child with newVal
                right = new BinarySearchTree(this, i);
            } else {
                //if there is a right child, add newVal to the right side of the tree
                right.insert(i);
            }
        }
    }

    /**
     * determines whether the BST contains toFind
     * has efficiency of O(log(n)) because it at most needs to search up to the depth of the tree
     * @param i int to find in the BST
     * @return boolean
     */
    public boolean contains(int i) {
        if(i == val) {
            return true;
        } else if(i < val) {
            return left != null && left.contains(i);
        } else {
            return right != null && right.contains(i);
        }
    }

    /**
     * returns the height of the tree from the current node
     * if called on root will return the right of the whole tree
     * the tree can hold log(h) - 1 nodes
     * @return int
     */
    public int getHeight() {
        int childHeight = 0;

        //find the greater of this tree's children's lengths
        if(!this.isLeaf()) {
            int leftHeight = left != null ? left.getHeight() : 0;
            int rightHeight = right != null ? right.getHeight() : 0;

            childHeight = leftHeight > rightHeight ? leftHeight : rightHeight;
        }

        //return larger child tree length + 1 for current node
        return childHeight + 1;
    }

    /**
     * deletes the node containing i from the BST
     * this will break if you try to call it to delete the root of the tree
     * if the root of the tree has no children
     * @param i int value of node to delete
     */
    public void delete(int i) {
        //if the value we're looking to delete is less than the current node's value, look in the left subtree
        if(i < val) {
            if(left != null) {
                left.delete(i);
            }
        } else if(i > val) { // else look in the right subtree
            if(right != null) {
                right.delete(i);
            }
        } else { //else if not <> it must be this node so delete it
            if(this.isLeaf()) {
                //if there are no children just null the reference to this object in its parent
                parent.replaceChild(i, null);
            } else if(this.hasSingleChild()) {
                /**
                 * if there's a single child replace it with the child's descendant with the value closest to i
                 * meaning the smallest of right or the largest of left
                 */
                int descVal = left != null ? left.getLargestDescendant().getVal() : right.getSmallestDescendant().getVal();
                delete(descVal);
                val = descVal;
            } else {
                /**
                 * if there's two children replace this node with the largest descendant of its left child
                 * the leaf's value will be larger than all left subtree values and less than all right subtree values
                 * making its placement function equivalently to the current node
                 * deleting the largest descendant node will cascade until the tree resettles by replacing a value with
                 * a leaf
                 */
                int largestLeftDescVal = left.getLargestDescendant().getVal();
                delete(largestLeftDescVal);
                val = largestLeftDescVal;
            }
        }
    }

    /**
     * gets the largest of this tree's descendants
     * helper for delete()
     * @return BinarySearchTree
     */
    private BinarySearchTree getLargestDescendant() {
        if(this.isLeaf()) {
            return this;
        }

        //get the right child if one exists, otherwise look in left subtree
        BinarySearchTree child = this.right != null ? this.right : this.left;

        //find the rightmost descendant
        while(child.right != null) {
            child = child.right;
        }

        return child;
    }

    /**
     * gets the smallest of this tree's descendants
     * helper for delete()
     * @return BinarySearchTree
     */
    private BinarySearchTree getSmallestDescendant() {
        if(this.isLeaf()) {
            return this;
        }

        //get the right child if one exists, otherwise look in left subtree
        BinarySearchTree child = this.left != null ? this.left : this.right;

        //find the rightmost descendant
        while(child.left != null) {
            child = child.left;
        }

        return child;
    }

    /**
     * replaces the child with value childVal with BST newChild
     * @param childVal int
     * @param newChild BinarySearchTree
     */
    public void replaceChild(int childVal, BinarySearchTree newChild) {
        if(left != null && left.getVal() == childVal) {
            left = newChild;
        } else if(right != null && right.getVal() == childVal) {
            right = newChild;
        }
    }

    /**
     * determines if the current node has no children and is as such a leaf
     * @return bool
     */
    public boolean isLeaf() {
        return left == null && right == null;
    }

    /**
     * determines if this node has a single child
     * @return bool
     */
    public boolean hasSingleChild() {
        // ^ is XOR (exclusive or) operator, which is equivalent to (left != null || right != null) && !(left != null & right != null)
        return left != null ^ right != null;
    }

    /**
     * wrapper for pre-order traversal because I can't seem to get rid of leading whitespace otherwise
     */
    public String preOrder() {
        return preOrderHelper().trim();
    }

    /**
     * performs a pre-order traversal of the tree, returning a string representing the values in the order they were reached
     */
    public String preOrderHelper() {
        String leftTraversal = left != null ? left.preOrderHelper() : "";
        String rightTraversal = right != null ? right.preOrderHelper() : "";
        return val + " " + leftTraversal + rightTraversal;
    }

    /**
     * wrapper for in-order traversal because I can't seem to get rid of leading whitespace otherwise
     */
    public String inOrder() {
        String s = inOrderHelper();

        return s.trim();
    }

    /**
     * performs an in-order traversal of the tree, returning a string representing the values in the order they were reached
     */
    public String inOrderHelper() {
        String leftTraversal = left != null ? left.inOrderHelper() : "";
        String rightTraversal = right != null ? right.inOrderHelper() : "";

        return leftTraversal + " " + val + rightTraversal;
    }

    /**
     * wrapper for post-order traversal because I can't seem to get rid of leading whitespace otherwise
     */
    public String postOrder() {
        return postOrderHelper().trim();
    }

    /**
     * performs a post-order traversal of the tree, returning a string representing the values in the order they were reached
     */
    public String postOrderHelper() {
        String leftTraversal = left != null ? left.postOrderHelper() : "";
        String rightTraversal = right != null ? right.postOrderHelper() : "";
        return leftTraversal + " " + rightTraversal + val;
    }
}
