#ifndef PRIORITY_QUEUE_HEADER
#define PRIORITY_QUEUE_HEADER

#include "queue.h"

typedef struct PriorityQueue {
    int levels;
    Queue *queues;
} PriorityQueue;

void PriorityQueue_init(PriorityQueue *q, int levels);
void PriorityQueue_enqueue(PriorityQueue *q, int n, int level);
int PriorityQueue_dequeue(PriorityQueue *q);
int PriorityQueue_size(PriorityQueue *q);

#endif
