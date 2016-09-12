#include <stdlib.h>
#include <stdio.h>

#include "arraylist.h"
#include "../test/assert.h"

void ArrayList_test(int *passed, int *total) {
    printf("\n\nArray List\n\n");

    ArrayList *test = malloc(sizeof(ArrayList));

    // [ 5 ]
    ArrayList_init(test, 5);

    *passed += ASSERT_INT_EQUALS(1, test->size, "initializes with 1 element");
    *total += 1;

    *passed += ASSERT_INT_EQUALS(5, ArrayList_get(test, 0), "retrieves first element");
    *total += 1;

    // [ 5, 10 ]
    ArrayList_append(test, 10);

    *passed += ASSERT_INT_EQUALS(2, test->size, "correct size after append");
    *total += 1;

    *passed += ASSERT_INT_EQUALS(10, ArrayList_get(test, 1), "retrieves appended element correctly");
    *total += 1;

    // [ 5, 15, 10 ]
    ArrayList_insert(test, 1, 15);

    *passed += ASSERT_INT_EQUALS(3, test->size, "correct size after insert");
    *total += 1;

    *passed += ASSERT_INT_EQUALS(15, ArrayList_get(test, 1), "retrieves inserted element correctly");
    *total += 1;

    // [ 20, 5, 15, 10 ]
    ArrayList_insert(test, 0, 20);

    *passed += ASSERT_INT_EQUALS(4, test->size, "correct size after insert at start of list");
    *total += 1;

    *passed += ASSERT_INT_EQUALS(20, ArrayList_get(test, 0), "retrieves element inserted at beginning correctly");
    *total += 1;

    // [ 20, 5, 25, 10 ]
    ArrayList_set(test, 2, 25);

    *passed += ASSERT_INT_EQUALS(4, test->size, "size does not change on set");
    *total += 1;

    *passed += ASSERT_INT_EQUALS(25, ArrayList_get(test, 2), "element correctly set by set");
    *total += 1;

    // [ 5, 25, 10 ]
    ArrayList_remove(test, 0);

    *passed += ASSERT_INT_EQUALS(3, test->size, "size correctly changes after removal from start");
    *total += 1;

    *passed += ASSERT_INT_EQUALS(5, ArrayList_get(test, 0), "list values are correctly changed after removal from start");
    *total += 1;

    // [ 5, 10 ]
    ArrayList_remove(test, 1);

    *passed += ASSERT_INT_EQUALS(2, test->size, "size correctly changes after removal from middle");
    *total += 1;

    *passed += ASSERT_INT_EQUALS(10, ArrayList_get(test, 1), "list values are correctly changed after middle removal");
    *total += 1;

    // [ 5 ]
    ArrayList_remove(test, 1);

    *passed += ASSERT_INT_EQUALS(1, test->size, "size correctly changes after removal from end");
    *total += 1;

    *passed += ASSERT_INT_EQUALS(5, ArrayList_get(test, 0), "list values are correctly changed after end removal");
    *total += 1;
}
