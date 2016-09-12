#ifndef LINKEDLIST_HEADER
#define LINKEDLIST_HEADER

// singly linked list
typedef struct LinkedList {
    int data;
    struct LinkedList *next;
} LinkedList;

void LinkedList_init(LinkedList *list, int n);
void LinkedList_insert(LinkedList *list, int i, int n);
void LinkedList_set(LinkedList *list, int i, int n);
void LinkedList_append(LinkedList *list, int n);
LinkedList* LinkedList_remove(LinkedList *list, int i);
int LinkedList_get(LinkedList *list, int i);
int LinkedList_size(LinkedList *list);

#endif
