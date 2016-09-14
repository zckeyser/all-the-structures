#include <stdlib.h>
#include <stdio.h>

#include "bst.h"

void BinarySearchTree_init(BinarySearchTree *node, BinarySearchTree *parent, int n) {
    node->value = n;
    node->count = 1;
    node->parent = parent;
    node->left = NULL;
    node->right = NULL;
}

void BinarySearchTree_insert(BinarySearchTree *root, int n) {
    if(n == root->value) {
        // a node with the given value already exists -- increment it
        root->count += 1;
    } else if(n < root->value) {
        // left side insert
        if(root->left != NULL) {
            // insert into left subtree
            BinarySearchTree_insert(root->left, n);
        } else {
            // create left node
            root->left = malloc(sizeof(BinarySearchTree));
            BinarySearchTree_init(root->left, n);
        }
    } else {
        // right side insert
        if(root->right != NULL) {
            // insert into right subtree
            BinarySearchTree_insert(root->right, n);
        } else {
            // create right node
            root->right = malloc(sizeof(BinarySearchTree));
            BinarySearchTree_init(root->right, n);
        }
    }
}

void BinarySearchTree_remove(BinarySearchTree *root, int n) {
    if(root->value == n) {
        // delete this node

        if(root->count > 1) {
            // decrement the counter -- no need to delete it if there's multiple instances
            root->count -= 1;
        } else if(root->right == NULL && root->left == NULL) {
            // this is a leaf, just null the reference to it on its parent and free it

            if(root->parent->left == root) {
                root->parent->left = NULL;
            } else {
                root->parent->right = NULL;
            }

            free(root);
        } else {
            // single child -- replace this with the max of the left or the min of the right
            BinarySearchTree *node = NULL;

            // get min of right or max of left
            // default to max of left so it works for both single child nodes
            // as well as double child nodes
            if(root->left != NULL) {
                node = root->left;
                while(node->right != NULL) {
                    node = node->right;
                }
            } else {
                node = root->right;
                while(node->left != NULL) {
                    node = node->left;
                }
            }

            // set this node to be equal to the node we grabbed
            // then delete the old node
            root->value = node->value;
            root->count = node->count;

            // so it gets deleted when we remove it
            node->count = 1;

            BinarySearchTree_remove(node, node->value);
        }
    } else if(n < root->value) {
        // try to delete from left subtree

        if(root->left == NULL) {
            printf("Attempt to delete non-existing value %d from BST", n);
            return;
        }

        BinarySearchTree_remove(root->left, n);
    } else {
        // try to delete from right subtree

        if(root->right == NULL) {
            printf("Attempt to delete non-existing value %d from BST", n);
            return;
        }

        BinarySearchTree_remove(root->right, n);
    }
}

int BinarySearchTree_contains(BinarySearchTree *root, int n) {
    return (root->value == n) ||
                ((root->value < n && root->left != NULL && BinarySearchTree_contains(root->left)) ||
                ((root->value > n && root->right != NULL && BinarySearchTree_contains(root->right)))
            );
}

int BinarySearchTree_max(BinarySearchTree *root) {
    return root->right == NULL ? root->value ? BinarySearchTree_max(root->right);
}

int BinarySerachTree_min(BinarySearchTree *root) {
    return root->left == NULL ? root->value ? BinarySearchTree_max(root->left);
}
