package trees;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Chris Keyser on 10/4/2016.
 */
public class BinarySearchTreeTest {
    private BinarySearchTree root;

    @Before
    public void setUp() {
        root = new BinarySearchTree(null, 50);
    }

    @Test
    public void BinarySearchTree_Initialize() {
        Assert.assertTrue("Root to initialize as a leaf", root.isLeaf());

        Assert.assertEquals("Root to initialize with height 1", root.getHeight(), 1);
    }

    @Test
    public void BinarySearchTree_Insert_Height() {
        populateTree();

        Assert.assertEquals("Tree to have correct height after being populated", 5, root.getHeight());
    }

    @Test
    public void BinarySearchTree_Contains_Left() {
        populateTree();

        Assert.assertTrue("Contains to find a value in the left subtree", root.contains(35));
    }

    @Test
    public void BinarySearchTree_Contains_Right() {
        populateTree();

        Assert.assertTrue("Contains to work in right subtree", root.contains(87));
    }

    @Test
    public void BinarySearchTree_Contains_Root() {
        populateTree();

        Assert.assertTrue("Contains to work on root value", root.contains(50));
    }

    @Test
    public void BinarySearchTree_Contains_NegativeCase() {
        populateTree();

        Assert.assertTrue("Contains to not find values that are not in the tree", !root.contains(1));
    }

    @Test
    public void BinarySearchTree_Insert_CorrectStructure() {
        populateTree();

        String treeStr = root.inOrder();
        String expected = "8 10 11 14 35 39 42 44 50 60 65 71 78 80 84 87 91 100";

        Assert.assertEquals("Tree to be constructed correctly after initial insertions", expected, treeStr);
    }

    @Test
    public void BinarySearchTree_Delete_TwoChildren() {
        populateTree();

        root.delete(35);

        String treeStr = root.inOrder();
        String expected = "8 10 11 14 39 42 44 50 60 65 71 78 80 84 87 91 100";

        Assert.assertEquals("Deletion of a node with two children", expected, treeStr);
    }

    @Test
    public void BinarySearchTree_Delete_SingleChild() {
        populateTree();

        root.delete(44);

        String treeStr = root.inOrder();
        String expected = "8 10 11 14 35 39 42 50 60 65 71 78 80 84 87 91 100";

        Assert.assertEquals("Deletion of a node with one child", expected, treeStr);
    }

    @Test
    public void BinarySearchTree_Delete_Leaf() {
        populateTree();

        //test deletion of leaf
        root.delete(10);

        String treeStr = root.inOrder();
        String expected = "8 11 14 35 39 42 44 50 60 65 71 78 80 84 87 91 100";

        Assert.assertEquals("Deletion of a leaf", expected, treeStr);
    }

    private void populateTree() {
        //populate left subtree
        root.insert(35);
        root.insert(39);
        root.insert(11);
        root.insert(8);
        root.insert(10);
        root.insert(14);
        root.insert(44);
        root.insert(42);

        //populate right subtree
        root.insert(78);
        root.insert(65);
        root.insert(60);
        root.insert(71);
        root.insert(84);
        root.insert(80);
        root.insert(91);
        root.insert(87);
        root.insert(100);
    }
}
