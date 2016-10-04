#ifndef TRAVERSAL_HEADER
#define TREE_TRAVERSAL_HEADER

#include "bst.h"
#include "binary.h"

char* Traversal_preorder(BinaryTree *root);
char* Traversal_inorder(BinaryTree *root);
char* Traversal_postorder(BinaryTree *root);

char* Traversal_preorder_bst(BinarySearchTree *root);
char* Traversal_inorder_bst(BinarySearchTree *root);
char* Traversal_postorder_bst(BinarySearchTree *root);

#endif
