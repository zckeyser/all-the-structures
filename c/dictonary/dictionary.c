#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#include "dictionary.h"

void expand(Dict *dict);
int hash(char s[]);

// TODO reimplement as linked list

void Dict_init(Dict *dict) {
    dict->size = DICT_START_SIZE;
}

void Dict_set(Dict *dict, char *key, int value) {
    int index = hash(key) % dict->size;
    Pair* p = malloc(sizeof(p));
    p->key = key;
    p->value = value;

    if(dict->contains[index] == 0) {
        // inserting a new value into an empty spot
        dict->data[index] = *p;

        // flag the bucket we just added to
        dict->contains[index] = 1;
    } else if(strcmp(dict->data[index].key, p->key) == 0) {
        // updating an existing value
        dict->data[index] = *p;
    } else {
        int j = index + 1;

        while(j != index && dict->contains[j] != 0) {
            if (j < dict->size) {
                j++;
            } else {
                // rollover to beginning of the array
                j = 0;
            }
        }

        if(j != index) {
            dict->data[j] = *p;

            // flag the bucket we just added to
            dict->contains[j] = 1;
        } else {
            // expand the internal array
            expand(dict);

            // try adding again now that we have room
            Dict_set(dict, key, value);
        }
    }
}

int Dict_get(Dict *dict, char *key) {
    int index = hash(key) % dict->size;

    if(dict->contains[index] == 0) {
        // we don't have it
        printf("Attempt to access non-existing key %s in Dict", key);
        return 0;
    } else if(strcmp(dict->data[index].key, key) == 0) {
        return dict->data[index].value;
    } else {
        int j = index + 1;

        while(j != index && dict->contains[j] != 0) {
            if(strcmp(dict->data[j].key, key) == 0) {
                return dict->data[j].value;
            }

            if (j < dict->size) {
                j++;
            } else {
                // rollover to beginning of the array
                j = 0;
            }
        }

        // couldn't find it
        printf("Attempt to access non-existing key %s in Dict", key);
        return 0;
    }
}

void expand(Dict *dict) {
    // copy original contents
    int originalSize = dict->size;
    Pair *tmp = malloc(originalSize * sizeof(Pair));
    memcpy(tmp, dict->data, originalSize * sizeof(Pair));

    // double the internal array size
    dict->size *= 2;
    realloc(dict->data, dict->size * sizeof(Pair));
    realloc(dict->contains, dict->size * sizeof(int));

    // clear out what was in the array
    for(int i = 0; i < originalSize; i++) {
        // mark as uncontained
        dict->contains[i] = 0;
    }

    // re-add the old contents back into the dictionary
    for(int i = 0; i < originalSize; i++) {
        Dict_set(dict, tmp[i].key, tmp[i].value);
    }
}

int hash(char s[]) {
    int output = 7;

    for(int i = 0; i < strlen(s); i++) {
        output *= 11 + s[i];
    }

    return output;
}
