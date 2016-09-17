#include <stdlib.h>
#include <stdio.h>

#include "list_search_test.h"
#include "linear.h"
#include "binary.h"
#include "../test/assert.h"

void ListSearch_test(int *passed, int *total) {
    printf("\n\nList Searches\n\n");

    int test[TEST_LIST_SIZE];

    for(int i = 0; i < TEST_LIST_SIZE; i++) {
        test[i] = i;
    }

    // Linear Search Tests
    *passed += ASSERT_INT_EQUALS(0, Linear_search(test, TEST_LIST_SIZE, 0), "Linear Search (beginning)");
    *passed += ASSERT_INT_EQUALS(TEST_LIST_SIZE / 2, Linear_search(test, TEST_LIST_SIZE, TEST_LIST_SIZE / 2), "Linear Search (middle)");
    *passed += ASSERT_INT_EQUALS(TEST_LIST_SIZE - 1, Linear_search(test, TEST_LIST_SIZE, TEST_LIST_SIZE - 1), "Linear Search (end)");
    *passed += ASSERT_INT_EQUALS(-1, Linear_search(test, TEST_LIST_SIZE, TEST_LIST_SIZE + 1), "Linear Search (negative)");
    *total += 4;

    // Binary Search Tests
    *passed += ASSERT_INT_EQUALS(0, Binary_search(test, 0, TEST_LIST_SIZE - 1, 0), "Binary Search (beginning)");
    *passed += ASSERT_INT_EQUALS(TEST_LIST_SIZE / 4, Binary_search(test, 0, TEST_LIST_SIZE - 1, TEST_LIST_SIZE / 4), "Binary Search (bottom quarter)");
    *passed += ASSERT_INT_EQUALS(TEST_LIST_SIZE / 2, Binary_search(test, 0, TEST_LIST_SIZE - 1, TEST_LIST_SIZE / 2), "Binary Search (middle)");
    *passed += ASSERT_INT_EQUALS(3 * TEST_LIST_SIZE / 4, Binary_search(test, 0, TEST_LIST_SIZE - 1, 3 * TEST_LIST_SIZE / 4), "Binary Search (upper quarter)");
    *passed += ASSERT_INT_EQUALS(TEST_LIST_SIZE - 1, Binary_search(test, 0, TEST_LIST_SIZE - 1, TEST_LIST_SIZE - 1), "Binary Search (end)");
    *passed += ASSERT_INT_EQUALS(-1, Binary_search(test, 0, TEST_LIST_SIZE - 1, TEST_LIST_SIZE + 1), "Binary Search (negative)");
    *total += 6;
}
