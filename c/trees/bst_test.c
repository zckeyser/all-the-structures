#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#include "bst_test.h"
#include "bst.h"
#include "traversal.h"
#include "../test/assert.h"

void BinarySearchTree_test(int *passed, int *total) {
    printf("\n\nBinary Search Tree\n\n");

    // create the tree to test
    BinarySearchTree *root = malloc(sizeof(BinarySearchTree));
    BinarySearchTree_init(root, NULL, 50);
    BinarySearchTree_insert(root, 10);
    BinarySearchTree_insert(root, 30);
    BinarySearchTree_insert(root, 42);
    BinarySearchTree_insert(root, 15);
    BinarySearchTree_insert(root, 3);
    BinarySearchTree_insert(root, 60);
    BinarySearchTree_insert(root, 80);
    BinarySearchTree_insert(root, 83);
    BinarySearchTree_insert(root, 24);
    BinarySearchTree_insert(root, 73);
    BinarySearchTree_insert(root, 87);
    BinarySearchTree_insert(root, 100);

    // verify max and min of original tree, contains
    *passed += ASSERT_INT_EQUALS(100, BinarySearchTree_max(root), "max");
    *passed += ASSERT_INT_EQUALS(3, BinarySearchTree_min(root), "min");
    *passed += ASSERT_TRUE(BinarySearchTree_contains(root, 15), "contains positive");
    *passed += ASSERT_FALSE(BinarySearchTree_contains(root, 20), "contains negative");
    *total += 4;

    // initial insertions
    char *result = malloc(sizeof(char));

    Traversal_inorder_bst(result, root);

    *passed += ASSERT_STR_EQUALS("3 10 15 24 30 42 50 60 73 80 83 87 100", result, "insertion");
    *total += 1;
    memset(result, 0, strlen(result));

    // leaf removal
    BinarySearchTree_remove(root, 3);

    Traversal_inorder_bst(result, root);

    *passed += ASSERT_STR_EQUALS("10 15 24 30 42 50 60 73 80 83 87 100", result, "leaf removal");
    *total += 1;
    memset(result, 0, strlen(result));

    // node with one child removal
    BinarySearchTree_remove(root, 87);

    Traversal_inorder_bst(result, root);

    *passed += ASSERT_STR_EQUALS("10 15 24 30 42 50 60 73 80 83 100", result, "single child removal");
    *total += 1;
    memset(result, 0, strlen(result));

    // node with two children removal
    BinarySearchTree_remove(root, 30);

    Traversal_inorder_bst(result, root);

    *passed += ASSERT_STR_EQUALS("10 15 24 42 50 60 73 80 83 100", result, "two children removal");
    *total += 1;
    memset(result, 0, strlen(result));

    // root removal
    BinarySearchTree_remove(root, 50);

    Traversal_inorder_bst(result, root);

    *passed += ASSERT_STR_EQUALS("10 15 24 42 60 73 80 83 100", result, "root removal");
    *total += 1;
    memset(result, 0, strlen(result));

    free(result);
    free(root);
}
