#include <stdlib.h>
#include <stdio.h>

#include "linkedlist.h"
#include "../test/assert.h"

void LinkedList_test(int *passed, int *total) {
    printf("\n\nLinked List\n\n");

    LinkedList *test = malloc(sizeof(LinkedList));

    // [ 5 ]
    LinkedList_init(test, 5);

    *passed += ASSERT_INT_EQUALS(1, LinkedList_size(test), "initializes with 1 element");
    *total += 1;

    *passed += ASSERT_INT_EQUALS(5, LinkedList_get(test, 0), "retrieves first element");
    *total += 1;

    // [ 5, 10 ]
    LinkedList_append(test, 10);

    *passed += ASSERT_INT_EQUALS(2, LinkedList_size(test), "correct size after append");
    *total += 1;

    *passed += ASSERT_INT_EQUALS(10, LinkedList_get(test, 1), "retrieves appended element correctly");
    *total += 1;

    // [ 5, 15, 10 ]
    LinkedList_insert(test, 1, 15);

    *passed += ASSERT_INT_EQUALS(3, LinkedList_size(test), "correct size after insert");
    *total += 1;

    *passed += ASSERT_INT_EQUALS(15, LinkedList_get(test, 1), "retrieves inserted element correctly");
    *total += 1;

    // [ 20, 5, 15, 10 ]
    LinkedList_insert(test, 0, 20);

    *passed += ASSERT_INT_EQUALS(4, LinkedList_size(test), "correct size after insert at start of list");
    *total += 1;

    *passed += ASSERT_INT_EQUALS(20, LinkedList_get(test, 0), "retrieves element inserted at beginning correctly");
    *total += 1;

    // [ 20, 5, 25, 10 ]
    LinkedList_set(test, 2, 25);

    *passed += ASSERT_INT_EQUALS(4, LinkedList_size(test), "size does not change on set");
    *total += 1;

    *passed += ASSERT_INT_EQUALS(25, LinkedList_get(test, 2), "element correctly set by set");
    *total += 1;

    // [ 5, 25, 10 ]
    LinkedList_remove(test, 0);

    *passed += ASSERT_INT_EQUALS(3, LinkedList_size(test), "size correctly changes after removal from start");
    *total += 1;

    *passed += ASSERT_INT_EQUALS(5, LinkedList_get(test, 0), "list values are correctly changed after removal from start");
    *total += 1;

    // [ 5, 10 ]
    LinkedList_remove(test, 1);

    *passed += ASSERT_INT_EQUALS(2, LinkedList_size(test), "size correctly changes after removal from middle");
    *total += 1;

    *passed += ASSERT_INT_EQUALS(10, LinkedList_get(test, 1), "list values are correctly changed after middle removal");
    *total += 1;

    // [ 5 ]
    LinkedList_remove(test, 1);

    *passed += ASSERT_INT_EQUALS(2, LinkedList_size(test), "size correctly changes after removal from end");
    *total += 1;

    *passed += ASSERT_INT_EQUALS(5, LinkedList_get(test, 0), "list values are correctly changed after end removal");
    *total += 1;
}
