#ifndef BINARY_TREE_HEADER
#define BINARY_TREE_HEADER

typedef struct BinaryTree {
    int value;
    struct BinaryTree *left;
    struct BinaryTree *right;
} BinaryTree;

void BinaryTree_init(BinaryTree *node, int n);
void BinaryTree_insertleft(BinaryTree *node, int n);
void BinaryTree_insertright(BinaryTree *node, int n);
int BinaryTree_size(BinaryTree *node);

#endif
