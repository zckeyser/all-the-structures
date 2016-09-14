#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#include "traversal.h"

// helpers so we can trim the output;
void preorder(char *out, BinaryTree *root);
void inorder(char *out, BinaryTree *root);
void postorder(char *out, BinaryTree *root);
void preorder_bst(char *out, BinarySearchTree *root);
void inorder_bst(char *out, BinarySearchTree *root);
void postorder_bst(char *out, BinarySearchTree *root);

void Traversal_preorder(char *out, BinaryTree *root) {
    out = malloc((sizeof(char) * BinaryTree_size(root) * 2) + 1);

    preorder(out, root);

    printf("trimming preorder");
    // set the termination character at the last character, since it'll be an extra space
    out[strlen(out) - 1] = 0;
}

void Traversal_inorder(char *out, BinaryTree *root) {
    out = malloc((sizeof(char) * BinaryTree_size(root) * 2) + 1);

    inorder(out, root);

    // set the termination character at the last character, since it'll be an extra space
    out[strlen(out) - 1] = 0;
}

void Traversal_postorder(char *out, BinaryTree *root) {
    out = malloc((sizeof(char) * BinaryTree_size(root) * 2) + 1);

    postorder(out, root);

    // set the termination character at the last character, since it'll be an extra space
    out[strlen(out) - 1] = 0;
}

void preorder(char *out, BinaryTree *root) {
    char val[15];
    sprintf(val, "%d ", root->value);

    strncat(out, val, 2);

    if(root->left != NULL) {
        preorder(out, root->left);
    }

    if(root->right != NULL) {
        preorder(out, root->right);
    }
}

void inorder(char *out, BinaryTree *root) {
    char val[15];
    sprintf(val, "%d ", root->value);

    if(root->left != NULL) {
        inorder(out, root->left);
    }

    strncat(out, val, 2);

    if(root->right != NULL) {
        inorder(out, root->right);
    }
}

void postorder(char *out, BinaryTree *root) {
    char val[15];
    sprintf(val, "%d ", root->value);

    if(root->left != NULL) {
        postorder(out, root->left);
    }

    if(root->right != NULL) {
        postorder(out, root->right);
    }

    strncat(out, val, 2);
}


void Traversal_preorder_bst(char *out, BinarySearchTree *root) {
    out = malloc((sizeof(char) * BinarySearchTree_size(root) * 2) + 1);

    preorder_bst(out, root);

    // set the termination character at the last character, since it'll be an extra space
    out[strlen(out) - 1] = 0;
}

void Traversal_inorder_bst(char *out, BinarySearchTree *root) {
    out = malloc((sizeof(char) * BinarySearchTree_size(root) * 2) + 1);

    inorder_bst(out, root);

    // set the termination character at the last character, since it'll be an extra space
    out[strlen(out) - 1] = 0;
}

void Traversal_postorder_bst(char *out, BinarySearchTree *root) {
    out = malloc((sizeof(char) * BinarySearchTree_size(root) * 2) + 1);

    postorder_bst(out, root);

    // set the termination character at the last character, since it'll be an extra space
    out[strlen(out) - 1] = 0;
}

void preorder_bst(char *out, BinarySearchTree *root) {
    char val[15];
    sprintf(val, "%d ", root->value);

    strncat(out, val, 2);

    if(root->left != NULL) {
        preorder_bst(out, root->left);
    }

    if(root->right != NULL) {
        preorder_bst(out, root->right);
    }
}

void inorder_bst(char *out, BinarySearchTree *root) {
    char val[15];
    sprintf(val, "%d ", root->value);

    if(root->left != NULL) {
        inorder_bst(out, root->left);
    }

    strncat(out, val, 2);

    if(root->right != NULL) {
        inorder_bst(out, root->right);
    }
}

void postorder_bst(char *out, BinarySearchTree *root) {
    char val[15];
    sprintf(val, "%d ", root->value);
    printf("%s", val);

    if(root->left != NULL) {
        postorder_bst(out, root->left);
    }

    if(root->right != NULL) {
        postorder_bst(out, root->right);
    }

    strncat(out, val, 2);
}
