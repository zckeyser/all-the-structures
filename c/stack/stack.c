#include "fun.h"

#define MAXSIZE 50

typedef struct StackT {
    int contents[MAXSIZE];
    int top;
} Stack;

Stack s;
s.top = -1;

void push(int i) {
    s.top = s.top + 1;
    s.contents[s.top] = i;
}

int pop() {
    retval = s.contents[s.top];
    s.contents[s.top] = NULL;
    s.top = s.top - 1;

    return retval;
}

int size() {
    return s.top + 1;
}
