#ifndef BINARY_TREE_HEADER
#define BINARY_TREE_HEADER

typedef struct BinaryTree {
    int value;
    struct BinaryTree *left;
    struct BinaryTree *right;
}

void BinaryTree_init(BinaryTree *node, int n);

#endif
