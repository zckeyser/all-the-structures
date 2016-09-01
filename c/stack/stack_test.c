#include <stdio.h>

#include "stack.h"
#include "../test/assert.h"

void test_stack(int* passed, int* total) {
    printf("\n\nStack\n\n");

    passed += ASSERT_INT_EQUALS(0, size());
    total++;

    push(10);

    passed += ASSERT_INT_EQUALS(1, size());
    total++;

    push(20);

    passed += ASSERT_INT_EQUALS(2, size());
    total++;

    int result = pop();

    passed += ASSERT_INT_EQUALS(20, result);
    total++;

    result = pop();

    passed += ASSERT_INT_EQUALS(10, result);
    total++;
}
