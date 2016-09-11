#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <time.h>

#include "dictionary_test.h"
#include "dictionary.h"

#include "../test/assert.h"

int randint(int n);
char *randstr();

void Dict_test(int *passed, int *total) {
    printf("\n\nDictionary\n\n");

    srand(time(NULL));

    Dict dict;

    Dict_init(&dict);

    // add a new item
    Dict_set(&dict, "foo", 10);

    *passed += ASSERT_INT_EQUALS(10, Dict_get(&dict, "foo"), "sets and retrieves a new item");
    *total += 1;

    // update an existing item
    Dict_set(&dict, "foo", 20);

    *passed += ASSERT_INT_EQUALS(20, Dict_get(&dict, "foo"), "sets and retrieves an updated item");
    *total += 1;

    // test expansion
    // so we can not destroy the test pass/fail count by adding hundreds of assertions to it
    int expansionPasses = 0;

    for(int i = 0; i < 200; i++) {
        // get the pair to add
        char *key = randstr(i);
        int value = i;

        if(strcmp(key, "") == 0) {
            printf("invalid key found");
        }

        // add the pair to the dict
        Dict_set(&dict, key, value);

        // verify the set worked
        expansionPasses += ASSERT_INT_EQUALS(value, Dict_get(&dict, key), "extended check");
    }

    if(expansionPasses == 100) {
        *passed += 1;
    }

    total += 1;
}

char *randstr() {
    int size = 8;
    char *s = malloc((size * sizeof(char)));

    for(int i = 0; i < size - 1; i++) {
        char c = randint(26) + 97;

        s[i] = c;
    }

    // needed to terminate the string
    s[size - 1] = 0;

    return s;
}

// returns a value in the range [0, n)
int randint(int n) {
    if ((n - 1) == RAND_MAX) {
        return rand();
    } else {
        return rand() % n;
    }
}
