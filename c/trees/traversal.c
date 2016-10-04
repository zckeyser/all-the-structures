#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#include "traversal.h"
#include "../util/sb.h"

// helpers so we can trim the output;
void preorder(StringBuilder *sb, BinaryTree *root);
void inorder(StringBuilder *sb, BinaryTree *root);
void postorder(StringBuilder *sb, BinaryTree *root);
void preorder_bst(StringBuilder *sb, BinarySearchTree *root);
void inorder_bst(StringBuilder *sb, BinarySearchTree *root);
void postorder_bst(StringBuilder *sb, BinarySearchTree *root);

// for sanitizing and copying over output
void copy(char *in);

char* Traversal_preorder(BinaryTree *root) {
    StringBuilder *sb = malloc(sizeof(StringBuilder));
    StringBuilder_init(sb);

    preorder(sb, root);

    char* out = StringBuilder_build(sb);
    // remove trailing whitespace
    out[strlen(out) - 1] = '\0';

    free(sb);

    return out;
}

char* Traversal_inorder(BinaryTree *root) {
    StringBuilder *sb = malloc(sizeof(StringBuilder));
    StringBuilder_init(sb);

    inorder(sb, root);

    char* out = StringBuilder_build(sb);
    // remove trailing whitespace
    out[strlen(out) - 1] = '\0';

    free(sb);

    return out;
}

char* Traversal_postorder(BinaryTree *root) {
    StringBuilder *sb = malloc(sizeof(StringBuilder));
    StringBuilder_init(sb);

    postorder(sb, root);

    char* out = StringBuilder_build(sb);
    // remove trailing whitespace
    out[strlen(out) - 1] = '\0';

    free(sb);

    return out;
}

void preorder(StringBuilder *sb, BinaryTree *root) {
    char val[11];
    sprintf(val, "%d ", root->value);

    StringBuilder_append(sb, val);

    if(root->left) {
        preorder(sb, root->left);
    }

    if(root->right) {
        preorder(sb, root->right);
    }
}

void inorder(StringBuilder *sb, BinaryTree *root) {
    char val[11];
    sprintf(val, "%d ", root->value);

    if(root->left) {
        inorder(sb, root->left);
    }

    StringBuilder_append(sb, val);

    if(root->right) {
        inorder(sb, root->right);
    }
}

void postorder(StringBuilder *sb, BinaryTree *root) {
    char val[11];
    sprintf(val, "%d ", root->value);

    if(root->left) {
        postorder(sb, root->left);
    }

    if(root->right) {
        postorder(sb, root->right);
    }

    StringBuilder_append(sb, val);
}


char* Traversal_preorder_bst(BinarySearchTree *root) {
    StringBuilder *sb = malloc(sizeof(StringBuilder));
    StringBuilder_init(sb);

    preorder_bst(sb, root);

    char* out = StringBuilder_build(sb);
    // remove trailing whitespace
    out[strlen(out) - 1] = '\0';

    free(sb);

    return out;
}

char* Traversal_inorder_bst(BinarySearchTree *root) {
    StringBuilder *sb = malloc(sizeof(StringBuilder));
    StringBuilder_init(sb);

    inorder_bst(sb, root);

    char* out = StringBuilder_build(sb);
    // remove trailing whitespace
    out[strlen(out) - 1] = '\0';

    free(sb);

    return out;
}

char* Traversal_postorder_bst(BinarySearchTree *root) {
    StringBuilder *sb = malloc(sizeof(StringBuilder));
    StringBuilder_init(sb);

    postorder_bst(sb, root);

    char* out = StringBuilder_build(sb);
    // remove trailing whitespace
    out[strlen(out) - 1] = '\0';

    free(sb);

    return out;
}

void preorder_bst(StringBuilder *sb, BinarySearchTree *root) {
    char val[11];
    sprintf(val, "%d ", root->value);

    StringBuilder_append(sb, val);

    if(root->left) {
        preorder_bst(sb, root->left);
    }

    if(root->right) {
        preorder_bst(sb, root->right);
    }
}

void inorder_bst(StringBuilder *sb, BinarySearchTree *root) {
    char val[11];
    sprintf(val, "%d ", root->value);

    if(root->left) {
        inorder_bst(sb, root->left);
    }

    StringBuilder_append(sb, val);

    if(root->right) {
        inorder_bst(sb, root->right);
    }
}

void postorder_bst(StringBuilder *sb, BinarySearchTree *root) {
    char val[11];
    sprintf(val, "%d ", root->value);

    if(root->left) {
        postorder_bst(sb, root->left);
    }

    if(root->right) {
        postorder_bst(sb, root->right);
    }

    StringBuilder_append(sb, val);
}
