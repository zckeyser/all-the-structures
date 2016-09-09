#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#include "dictionary.h"

void expand(Dict *dict);
unsigned long hash(char s[]);

// TODO reimplement as linked list

void Dict_init(Dict *dict) {
    dict->size = DICT_SIZE;

    // initialize array to be flagged empty
    for(int i = 0; i < dict->size; i++) {
        dict->contains[i] = 0;
    }
}

void Dict_set(Dict *dict, char *key, int value) {
    int index = hash(key) % dict->size;

    Pair* p = malloc(sizeof(p));
    p->key = key;
    p->value = value;
    p->next = NULL;

    printf("checking index %d for contains\n", index);

    if(dict->contains[index] == 0) {
        printf("add\n");
        // inserting a new value into an empty spot
        dict->data[index] = *p;

        // flag the bucket we just added to
        dict->contains[index] = 1;
    } else if(strcmp(dict->data[index].key, p->key) == 0) {
        printf("update\n");
        // updating an existing value
        dict->data[index] = *p;
    } else {
        printf("collision\n");

        Pair *last = &dict->data[index];

        while(last->next != NULL) {
            last = last->next;
        }

        // append it to the end of the list
        last->next = p;
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
        Pair* curr = &dict->data[index];

        while(curr->next != NULL) {
            if(strcmp(curr->key, key) == 0) {
                return curr->value;
            } else {
                curr = curr->next;
            }
        }

        // couldn't find it
        printf("Attempt to access non-existing key %s in Dict", key);
        return 0;
    }
}

unsigned long hash(char str[])
{
    unsigned long hash = 5381;
    int c;

    for(int i = 0; i < strlen(str); i++) {
        int c = str[i];

        hash = ((hash << 5) + hash) ^ c; /* hash * 33 ^ c */
    }

    return hash;
}
