#ifndef ARRAYLIST_HEADER
#define ARRAYLIST_HEADER

typedef struct ArrayList {
    int size;
    int *data;
} ArrayList;

void ArrayList_init(ArrayList *list, int n);
void ArrayList_insert(ArrayList *list, int i, int n);
void ArrayList_set(ArrayList *list, int i, int n);
void ArrayList_append(ArrayList *list, int n);
void ArrayList_remove(ArrayList *list, int i);
int ArrayList_get(ArrayList *list, int i);

#endif
