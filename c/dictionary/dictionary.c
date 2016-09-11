#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#include "dictionary.h"

void expand(Dict *dict);
unsigned long hash(char s[]);

void Dict_init(Dict *dict) {
    dict->size = DICT_SIZE;

    // initialize array to be flagged empty
    for(int i = 0; i < dict->size; i++) {
        dict->contains[i] = 0;
    }
}

void Dict_set(Dict *dict, char *key, int value) {
    int index = hash(key) % dict->size;

    if(dict->contains[index] == 0) {
        Pair *p = malloc(sizeof(Pair));
        p->key = strdup(key);
        p->value = value;
        p->next = NULL;

        // inserting a new value into an empty spot
        dict->data[index] = *p;

        // flag the bucket we just added to
        dict->contains[index] = 1;
    } else if(strcmp(dict->data[index].key, key) == 0) {
        // update an existing value
        dict->data[index].value = value;
    } else {
        Pair *last = &dict->data[index];

        while(last->next != NULL) {
            last = last->next;
        }

        // append it to the end of the list
        last->next = malloc(sizeof(Pair));
        last->next->key = strdup(key);
        last->next->value = value;
        last->next->next = NULL;
    }
}

int Dict_get(Dict *dict, char *key) {
    int index = hash(key) % dict->size;

    if(dict->contains[index] == 0) {
        // we don't have it
        printf("Attempt to access non-existing key %s in Dict (non-collision)\n", key);
        return 0;
    } else  {
        Pair* curr = &dict->data[index];

        // is it in the first node of this bucket?
        if(strcmp(curr->key, key) == 0) {
            return curr->value;
        }

        // collision -- check the other nodes, if any
        while(curr != NULL) {
            if(strcmp(curr->key, key) == 0) {
                return curr->value;
            } else {
                curr = curr->next;
            }
        }

        // couldn't find it
        printf("Attempt to access non-existing key %s in Dict (collision)\n", key);
        return 0;
    }
}

unsigned long hash(char str[])
{
    unsigned long hash = 5381;

    for(int i = 0; i < strlen(str); i++) {
        int c = str[i];

        hash = ((hash << 5) + hash) ^ c; /* hash * 33 ^ c */
    }

    return hash;
}
