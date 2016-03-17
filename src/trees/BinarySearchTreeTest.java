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
        expect(root.isLeaf()); // 1

        expectEquals(root.getHeight(), 1); // 2

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
        expect(root.hasSingleChild()); // 3

        expectEquals(root.getHeight(), 5); // 4

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
        expect(root.contains(35)); // 5
        expect(!root.contains(1)); // 6
        expect(root.contains(87)); // 7
        expect(root.contains(50)); // 8

        expectEquals(root.getHeight(), 5); // 9

        String treeStr = root.inOrder();
        String expected = "8 10 11 14 35 39 42 44 50 60 65 71 78 80 84 87 91 100";

        expectEquals(treeStr, expected); // 10

        // test deletion of node with two children
        root.delete(35);

        treeStr = root.inOrder();
        expected = "8 10 11 14 39 42 44 50 60 65 71 78 80 84 87 91 100";

        expectEquals(treeStr, expected); // 11

        //test deletion of node with one child
        root.delete(44);

        treeStr = root.inOrder();
        expected = "8 10 11 14 39 42 50 60 65 71 78 80 84 87 91 100";

        expectEquals(treeStr, expected); // 11

        //test deletion of leaf
        root.delete(10);

        treeStr = root.inOrder();
        expected = "8 11 14 39 42 50 60 65 71 78 80 84 87 91 100";

        expectEquals(treeStr, expected); // 11
    }
}
