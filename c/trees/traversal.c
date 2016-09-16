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

// for sanitizing and copying over output
void copy(char *out, char *in);

void Traversal_preorder(char *out, BinaryTree *root) {
    char *result = malloc((sizeof(char) * BinaryTree_size(root) * 15) + 1);
    result[0] = '\0';

    preorder(result, root);

    copy(out, result);
}

void Traversal_inorder(char *out, BinaryTree *root) {
    char *result = malloc((sizeof(char) * BinaryTree_size(root) * 15) + 1);
    result[0] = '\0';

    inorder(result, root);

    copy(out, result);
}

void Traversal_postorder(char *out, BinaryTree *root) {
    char *result = malloc((sizeof(char) * BinaryTree_size(root) * 15) + 1);
    result[0] = '\0';

    postorder(result, root);

    copy(out, result);
}

void preorder(char *out, BinaryTree *root) {
    char val[15];
    sprintf(val, "%d ", root->value);

    strncat(out, val, 15);

    if(root->left) {
        preorder(out, root->left);
    }

    if(root->right) {
        preorder(out, root->right);
    }
}

void inorder(char *out, BinaryTree *root) {
    char val[15];
    sprintf(val, "%d ", root->value);

    if(root->left) {
        inorder(out, root->left);
    }

    strncat(out, val, 15);

    if(root->right) {
        inorder(out, root->right);
    }
}

void postorder(char *out, BinaryTree *root) {
    char val[15];
    sprintf(val, "%d ", root->value);

    if(root->left) {
        postorder(out, root->left);
    }

    if(root->right) {
        postorder(out, root->right);
    }

    strncat(out, val, 15);
}


void Traversal_preorder_bst(char *out, BinarySearchTree *root) {
    char *result = malloc((sizeof(char) * BinarySearchTree_size(root) * 15) + 1);
    result[0] = '\0';

    preorder_bst(result, root);

    copy(out, result);
}

void Traversal_inorder_bst(char *out, BinarySearchTree *root) {
    char *result = malloc((sizeof(char) * BinarySearchTree_size(root) * 15) + 1);
    result[0] = '\0';

    inorder_bst(result, root);

    copy(out, result);
}

void Traversal_postorder_bst(char *out, BinarySearchTree *root) {
    char *result = malloc((sizeof(char) * BinarySearchTree_size(root) * 15) + 1);
    result[0] = '\0';

    postorder_bst(result, root);

    copy(out, result);
}

void preorder_bst(char *out, BinarySearchTree *root) {
    char val[15];
    sprintf(val, "%d ", root->value);

    strncat(out, val, 15);

    if(root->left) {
        preorder_bst(out, root->left);
    }

    if(root->right) {
        preorder_bst(out, root->right);
    }
}

void inorder_bst(char *out, BinarySearchTree *root) {
    char val[15];
    sprintf(val, "%d ", root->value);

    if(root->left) {
        inorder_bst(out, root->left);
    }

    strncat(out, val, 15);

    if(root->right) {
        inorder_bst(out, root->right);
    }
}

void postorder_bst(char *out, BinarySearchTree *root) {
    char val[15];
    sprintf(val, "%d ", root->value);

    if(root->left) {
        postorder_bst(out, root->left);
    }

    if(root->right) {
        postorder_bst(out, root->right);
    }

    strncat(out, val, 15);
}

void copy(char *out, char *in) {
    // copy the string over
    realloc(out, (sizeof(char) * strlen(in)));

    strcpy(out, in);

    out[strlen(out) - 1] = '\0';

    free(in);
}
