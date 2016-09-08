#include <stdio.h>

#include "stack.h"

void Stack_init(Stack *s) {
    s->top = -1;
}

void Stack_push(Stack *s, int n) {
    if(s->top == STACK_MAX - 1) {
        printf("Stack overflow on pushing %d", n);
        return;
    }

    s->top++;
    s->data[s->top] = n;
}

int Stack_pop(Stack *s) {
    if(s->top == -1) {
        printf("Stack underflow on pop");
        return 0;
    }

    int retval = s->data[s->top];

    s->top--;

    return retval;
}

int Stack_size(Stack *s) {
    return s->top + 1;
}
