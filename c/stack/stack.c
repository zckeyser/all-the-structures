#include "stack.h"

void Stack_init(Stack *s) {
    s->top = -1;
}

void Stack_push(Stack *s, int i) {
    s->top++;
    s->contents[s->top] = i;
}

int Stack_pop(Stack *s) {
    int retval = s->contents[s->top];

    s->top--;

    return retval;
}

int Stack_size(Stack *s) {
    return s->top + 1;
}
