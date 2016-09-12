#ifndef ARRAYLIST_HEADER
#define ARRAYLIST_HEADER

typedef struct ArrayList {
    int size;
    int data[];
} ArrayList;

ArrayList_add(ArrayList *list, int i, int n);
ArrayList_get(ArrayList *list, int i);
ArrayList_append(ArrayList *list, int n);
ArrayList_remove(ArrayList *list, int i);

#endif
