#include <stdlib.h>
#include <stdio.h>

#include "binary.h"
#include "traversal_test.h"
#include "traversal.h"
#include "../test/assert.h"

void Traversal_test(int *passed, int *total) {
    printf("\n\nTree Traversal\n\n");

    // create tree to traverse
    BinaryTree *root = malloc(sizeof(BinaryTree));

    BinaryTree_init(root, 1);

    //        1
    //    2       3
    //  4   5   6   7
    BinaryTree_insertleft(root, 2);
    BinaryTree_insertright(root, 3);
    BinaryTree_insertleft(root->left, 4);
    BinaryTree_insertright(root->left, 5);
    BinaryTree_insertleft(root->right, 6);
    BinaryTree_insertright(root->right, 7);

    // verify traversal outputs
    char *result;

    // preorder
    result = Traversal_preorder(root);

    *passed += ASSERT_STR_EQUALS("1 2 4 5 3 6 7", result, "preorder traversal");
    *total += 1;

    // // inorder
    // result = malloc(sizeof(char));
    // Traversal_inorder(result, root);
    //
    // *passed += ASSERT_STR_EQUALS("4 2 5 1 6 3 7", result, "inorder traversal");
    // *total += 1;
    //
    // // postorder
    // result = malloc(sizeof(char));
    // Traversal_postorder(result, root);
    //
    // *passed += ASSERT_STR_EQUALS("4 5 2 6 7 3 1", result, "postorder traversal");
    // *total += 1;
}
