#include <stdio.h>
#include <stdlib.h>

#include "stack.h"
#include "../test/assert.h"

void Stack_test(int *passed, int *total) {
    printf("\n\nStack\n\n");
    Stack *s = malloc(sizeof(Stack));
    Stack_init(s);

    *passed += ASSERT_INT_EQUALS(0, Stack_size(s), "Stack is initialized to be empty");
    *total += 1;

    Stack_push(s, 10);

    *passed += ASSERT_INT_EQUALS(1, Stack_size(s), "Stack has correct size after first push");
    *total += 1;

    Stack_push(s, 20);

    *passed += ASSERT_INT_EQUALS(2, Stack_size(s), "Stack has correct size after second push");
    *total += 1;

    int result = Stack_pop(s);

    *passed += ASSERT_INT_EQUALS(20, result, "Stack pops correct value first");
    *total += 1;

    result = Stack_pop(s);

    *passed += ASSERT_INT_EQUALS(10, result, "Stack pops correct value second");
    *total += 1;

    *passed += ASSERT_INT_EQUALS(0, Stack_size(s), "Stack is empty after all pops");
    *total += 1;
}
