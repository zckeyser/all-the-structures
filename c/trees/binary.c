#include "binary.h"

void BinaryTree_init(BinaryTree *node, int n) {
    node->value = n;
    node->left = NULL;
    node->right = NULL;
}
