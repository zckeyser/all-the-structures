#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#include "traversal.h"

// helpers so we can trim the output;
void preorder(char *out, BinarySearchTree *root);
void inorder(char *out, BinarySearchTree *root);
void postorder(char *out, BinarySearchTree *root);

void Traversal_preorder(char *out, BinarySearchTree *root) {
    preorder(out, root);

    // set the termination character at the last character, since it'll be an extra space
    out[strlen(out) - 1] = 0;
}

void Traversal_inorder(char *out, BinarySearchTree *root) {
    inorder(out, root);

    // set the termination character at the last character, since it'll be an extra space
    out[strlen(out) - 1] = 0;
}

void Traversal_postorder(char *out, BinarySearchTree *root) {
    postorder(out, root);

    // set the termination character at the last character, since it'll be an extra space
    out[strlen(out) - 1] = 0;
}

void preorder(char *out, BinarySearchTree *root) {
    char *val;
    sprintf(val, "%d ", root->value);

    strcat(out, val);

    if(root->left != NULL) {
        preorder(out, root->left);
    }

    if(root->right != NULL) {
        preorder(out, root->right);
    }
}

void inorder(char *out, BinarySearchTree *root) {
    char *val;
    sprintf(val, "%d ", root->value);

    if(root->left != NULL) {
        inorder(out, root->left);
    }

    strcat(out, val);

    if(root->right != NULL) {
        inorder(out, root->right);
    }
}

void postorder(char *out, BinarySearchTree *root) {
    char *val;
    sprintf(val, "%d ", root->value);

    if(root->left != NULL) {
        postorder(out, root->left);
    }

    if(root->right != NULL) {
        postorder(out, root->right);
    }

    strcat(out, val);
}
