package trees;

import test.Test;

/**
 * Created by Chris Keyser on 3/17/2016.
 * Tests the BST class to ensure its implementations work correctly
 * I'm too lazy to figure out how to run maven in a normal console app so I'm just doing it manually
 */
public class BinarySearchTreeTest extends Test {
    @Override
    public void run() {
        BinarySearchTree root = new BinarySearchTree(null, 50);

        //test isLeaf() and getHeight() with no children
        expect("Root to initialize as a leaf", root.isLeaf());

        expectEquals("Root to initialize with height 1", root.getHeight(), 1);

        //populate left subtree
        root.insert(35);
        root.insert(39);
        root.insert(11);
        root.insert(8);
        root.insert(10);
        root.insert(14);
        root.insert(44);
        root.insert(42);

        //test hasSingleChild() and getHeight() with one child
        expect("Root to have a single child when only data < root has been added", root.hasSingleChild());

        expectEquals("Tree to have height 3 after left subtree was added", root.getHeight(), 5);

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

        //test contains and getHeight() with two children
        expect("Contains to find a value in the left subtree", root.contains(35));
        expect("Contains to not find values that are not in the tree", !root.contains(1));
        expect("Contains to work in right subtree", root.contains(87));
        expect("Contains to work on root value", root.contains(50));

        expectEquals("Tree height to equal 5 when all data has been added", root.getHeight(), 5);

        String treeStr = root.inOrder();
        String expected = "8 10 11 14 35 39 42 44 50 60 65 71 78 80 84 87 91 100";

        expectEquals("Tree to be constructed correctly after initial insertions", treeStr, expected);

        // test deletion of node with two children
        root.delete(35);

        treeStr = root.inOrder();
        expected = "8 10 11 14 39 42 44 50 60 65 71 78 80 84 87 91 100";

        expectEquals("Deletion of a node with two children", treeStr, expected);

        //test deletion of node with one child
        root.delete(44);

        treeStr = root.inOrder();
        expected = "8 10 11 14 39 42 50 60 65 71 78 80 84 87 91 100";

        expectEquals("Deletion of a node with one child", treeStr, expected);

        //test deletion of leaf
        root.delete(10);

        treeStr = root.inOrder();
        expected = "8 11 14 39 42 50 60 65 71 78 80 84 87 91 100";

        expectEquals("Deletion of a leaf", treeStr, expected);
    }
}
