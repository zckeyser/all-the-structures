#include <stdio.h>

#include "stack.h"
#include "../test/assert.h"

void test_stack(int *passed, int *total) {
    printf("\n\nStack\n\n");
    Stack s;
    Stack_init(&s);

    passed += ASSERT_INT_EQUALS(0, Stack_size(&s));
    total++;

    Stack_push(&s, 10);

    passed += ASSERT_INT_EQUALS(1, Stack_size(&s));
    total++;

    Stack_push(&s, 20);

    passed += ASSERT_INT_EQUALS(2, Stack_size(&s));
    total++;

    int result = Stack_pop(&s);

    passed += ASSERT_INT_EQUALS(20, result);
    total++;

    result = Stack_pop(&s);

    passed += ASSERT_INT_EQUALS(10, result);
    total++;
}
