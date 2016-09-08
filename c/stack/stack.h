#ifndef STACK_HEADER
#define STACK_HEADER

#define STACK_MAX 100

struct Stack {
    int contents[STACK_MAX];
    int top;
};
typedef struct Stack Stack;

void Stack_init(Stack *s);
void Stack_push(Stack *s, int i);
int Stack_pop(Stack *s);
int Stack_size(Stack *s);

#endif
