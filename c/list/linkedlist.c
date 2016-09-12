#include <stdlib.h>
#include <stdio.h>

#include "linkedlist.h"

LinkedList* nodeat(LinkedList *list, int i);

void LinkedList_init(LinkedList *list, int n) {
    list->data = n;
    list->next = NULL;
}

void LinkedList_insert(LinkedList *list, int i, int n) {
    LinkedList *l = nodeat(list, i);

    if(l == NULL) return;

    // insert the value
    LinkedList *toinsert = malloc(sizeof(LinkedList));

    // insert before the given node by setting the new value
    // to have the given node's data, then setting
    // the given node's data to the new data
    toinsert->data = l->data;
    toinsert->next = l->next;

    l->data = n;
    l->next = toinsert;
}

void LinkedList_set(LinkedList *list, int i, int n) {
    LinkedList *l = nodeat(list, i);

    if(l == NULL) return;

    l->data = n;
}

void LinkedList_append(LinkedList *list, int n) {
    LinkedList *curr = list;

    // find the last node
    while(curr->next != NULL)
        curr = curr->next;

    // append new node
    curr->next = malloc(sizeof(LinkedList));
    curr->next->data = n;
    curr->next->next = NULL;
}

LinkedList* LinkedList_remove(LinkedList *list, int i) {
    LinkedList *l;

    // beginning removal special case
    if(i == 0) {
        l = list->next;

        // free the unused node
        list->next = NULL;
        free(list);

        return l;
    }

    // find the node before the one we're deleting
    l = nodeat(list, i - 1);

    // couldn't find it -- out of range
    if(l == NULL) return NULL;

    // the node we're supposed to delete is out of range
    if(l->next == NULL) {
        printf("Attempt to access out of range index %d in LinkedList", i);
        return NULL;
    }

    // hold a reference so we can free it later
    LinkedList *todelete = l->next;

    // link past the node we're deleting
    l->next = l->next->next;

    // free the unused node
    free(todelete);

    return l;
}

int LinkedList_get(LinkedList *list, int i) {
    LinkedList *l = nodeat(list, i);

    if(l == NULL) return 0;

    return l->data;
}

int LinkedList_size(LinkedList *list) {
    LinkedList *curr = list;
    int size = 1;

    while(curr->next != NULL) {
        curr = curr->next;
        size++;
    }

    return size;
}

LinkedList* nodeat(LinkedList *list, int i) {
    LinkedList *curr = list;
    int j = i;

    // move to where we're inserting
    while(j > 0) {
        // we're trying to insert out of range
        if(curr->next == NULL) {
            printf("Attempt to access out of range index %d in LinkedList", i);
            return NULL;
        } else {
            curr = curr->next;
            j--;
        }
    }

    return curr;
}
