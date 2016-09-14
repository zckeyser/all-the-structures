#include <stdlib.h>

#include "binary.h"

void BinaryTree_init(BinaryTree *node, int n) {
    node->value = n;
    node->left = NULL;
    node->right = NULL;
}

void BinaryTree_insertleft(BinaryTree *node, int n) {
    node->left = malloc(sizeof(BinaryTree));
    BinaryTree_init(node->left, n);
}

void BinaryTree_insertright(BinaryTree *node, int n) {
    node->right = malloc(sizeof(BinaryTree));
    BinaryTree_init(node->right, n);
}

int BinaryTree_size(BinaryTree *node) {
    if(node == NULL) {
        return 0;
    } else {
        return 1 + BinaryTree_size(node->left) + BinaryTree_size(node->right);
    }
}
