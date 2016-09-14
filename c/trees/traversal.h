#ifndef TRAVERSAL_HEADER
#define TREE_TRAVERSAL_HEADER

#include "bst.h"
#include "binary.h"

void Traversal_preorder(char *out, BinaryTree *root);
void Traversal_inorder(char *out, BinaryTree *root);
void Traversal_postorder(char *out, BinaryTree *root);

void Traversal_preorder_bst(char *out, BinarySearchTree *root);
void Traversal_inorder_bst(char *out, BinarySearchTree *root);
void Traversal_postorder_bst(char *out, BinarySearchTree *root);

#endif
