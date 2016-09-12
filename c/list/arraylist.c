#include <stdlib.h>
#include <stdio.h>

#include "arraylist.h"
#include "../util/swap.h"

void ArrayList_init(ArrayList *list, int n) {
    list->size = 1;
    list->data = malloc(sizeof(int));
    list->data[0] = n;
}

void ArrayList_insert(ArrayList *list, int i, int n) {
    if(i >= list->size || i < 0) {
        printf("Attempt to insert into ArrayList at out-of-range index %d", i);
        return;
    }

    // increase internal array size
    list->size += 1;
    list->data = realloc(list->data, list->size * sizeof(int));

    // from the end of the array
    int j = list->size - 1;

    // shift the part of the array after the given index up 1
    while(j > i) {
        swap(list->data, j, j - 1);
        j--;
    }

    // now that the spot is clear, fill it with the new data
    list->data[i] = n;
}

void ArrayList_set(ArrayList *list, int i, int n) {
    if(i >= list->size || i < 0) {
        printf("Attempt to set in ArrayList at out-of-range index %d", i);
        return;
    }

    list->data[i] = n;
}

void ArrayList_append(ArrayList *list, int n) {
    // increase internal array size
    list->size += 1;
    list->data = realloc(list->data, list->size * sizeof(int));

    list->data[list->size - 1] = n;
}

void ArrayList_remove(ArrayList *list, int i) {
    // shift everything to right of index over, overwriting the index's value
    for(int j = i + 1; j < list->size; j++) {
        swap(list->data, j, j - 1);
    }

    list->size -= 1;

    // reallocate memory to not waste any on the empty slot
    list->data = realloc(list->data, list->size * sizeof(int));
}

int ArrayList_get(ArrayList *list, int i) {
    if(i >= list->size || i < 0) {
        printf("Attempt to get from ArrayList at out-of-range index %d", i);
        return 0;
    }

    return list->data[i];
}
