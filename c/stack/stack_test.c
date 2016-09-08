#include <stdio.h>

#include "stack.h"
#include "../test/assert.h"

void Stack_test(int *passed, int *total) {
    printf("\n\nStack\n\n");
    Stack s;
    Stack_init(&s);

    *passed += ASSERT_INT_EQUALS(0, Stack_size(&s));
    *total += 1;

    Stack_push(&s, 10);

    *passed += ASSERT_INT_EQUALS(1, Stack_size(&s));
    *total += 1;

    Stack_push(&s, 20);

    *passed += ASSERT_INT_EQUALS(2, Stack_size(&s));
    *total += 1;

    int result = Stack_pop(&s);

    *passed += ASSERT_INT_EQUALS(20, result);
    *total += 1;

    result = Stack_pop(&s);

    *passed += ASSERT_INT_EQUALS(10, result);
    *total += 1;
}
