#include <stdio.h>
#include <string.h>

#include "dictionary.h"

void expand(Dict* dict);
int hash(char[] s);

void Dict_init(Dict* dict) {
    dict->size = DICT_START_SIZE;
}

void Dict_set(Dict* dict, char key[], int value) {
    int index = hash(key) % dict->size;
    Pair p;
    p->key = key;
    p->value = value;

    if(dict->data[index] == NULL) {
        // inserting a new value into an empty spot
        dict->data[index] = p;
    } else if(strcmp(dict->data[index]->key, p->key) == 0) {
        // updating an existing value
        dict->data[index] = p;
    } else {
        int j = index + 1;

        while(j != index && dict->data[j] != NULL) {
            if (j < dict->size) {
                j++;
            } else {
                // rollover to beginning of the array
                j = 0;
            }
        }

        if(j != index) {
            dict->data[j] = p;
        } else {
            // the dict is full, we need to expand
            expand(dict);

            // now try to insert again
            Dict_set(dict, key, value);
        }
    }
}

int Dict_get(Dict* dict, char key[]) {
    int index = hash(key) % dict->size;

    if(dict->data[index] == NULL) {
        // we don't have it
        printf("Attmempt to access non-existing key %s in Dict", key);
        return 0;
    } else if(strcmp(dict->data[index]->key, key) == 0) {
        return dict->data[index]->value;
    } else {
        int j = index + 1;

        while(j != index && dict->data[j] != NULL) {
            if(strcmp(dict->data[j]->key, key) == 0) {
                return dict->data[j]->value;
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

void expand(Dict* dict) {
    // so we can re-insert everything
    int oldSize = dict->size;
    struct Pair tmp[] = dict->data;

    // double our size
    dict->size *= 2;

    // reallocate the array
    dict->data = malloc(dict->size * sizeof(struct Pair));

    for(int i = 0; i < oldSize; i++) {
        struct Pair pair = tmp[i];

        Dict_set(dict, pair->key, pair->value);
    }

    free(tmp);
}

int hash(char[] s) {
    int length = sizeof(s) / sizeof(char);
    int output = 7;

    for(int i = 0; i < length; i++) {
        output *= 11 + s[i];
    }

    return output;
}
