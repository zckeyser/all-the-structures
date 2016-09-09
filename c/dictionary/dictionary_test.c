#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#include "dictionary_test.h"
#include "dictionary.h"

#include "../test/assert.h"

char *strFromIndex(int index);

void Dict_test(int *passed, int *total) {
    printf("\n\nDictionary\n\n");

    Dict dict;

    Dict_init(&dict);

    printf("initialized\n");

    // add a new item
    Dict_set(&dict, "foo", 10);

    printf("added first item\n");

    *passed += ASSERT_INT_EQUALS(10, Dict_get(&dict, "foo"), "sets and retrieves a new item");
    *total += 1;

    // update an existing item
    Dict_set(&dict, "foo", 20);

    *passed += ASSERT_INT_EQUALS(20, Dict_get(&dict, "foo"), "sets and retrieves an updated item");
    *total += 1;

    Pair inserted[500];

    // expansion
    for(int i = 0; i < 500; i++) {
        // get the pair to add
        char *key = strFromIndex(i);
        int value = i;

        // add the pair to the dict
        Dict_set(&dict, key, value);

        // record the pair so we can verify it worked
        Pair p;
        p.key = key;
        p.value = value;

        inserted[i] = p;
    }

    // test expansion
    // so we can not destroy the test pass/fail count by adding 500 assertions to it
    int expansionPasses = 0;

    for(int i = 0; i < 500; i++) {
        expansionPasses += ASSERT_INT_EQUALS(inserted[i].value, Dict_get(&dict, inserted[i].key), "expansion check");
    }

    if(expansionPasses == 500) {
        *passed += 1;
    }

    total += 1;
}

char *strFromIndex(int index) {
    // # of times we can go through the alphabet, round up
    int size = (index / 26) + 1;
    char *s = malloc(size * sizeof(char));

    // lowercase letter corresponding to index
    char c = (index % 26) + 97;

    for(int i = 0; i < size; i++) {
        s[i] = c;
    }

    return s;
}
