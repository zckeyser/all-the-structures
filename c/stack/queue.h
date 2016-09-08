#ifndef QUEUE_HEADER
#define QUEUE_HEADER

#define QUEUE_MAX 100

struct Queue {
    int data[QUEUE_MAX];
    int front;
    int rear;
};
typedef struct Queue Queue;

void Queue_init(Queue *q);
void Queue_enqueue(Queue *q, int n);
int Queue_dequeue(Queue *q);
int Queue_size(Queue *q);

#endif
