#include <stdlib.h>
#include <stdio.h>

#include "priority_queue.h"

void PriorityQueue_init(PriorityQueue *q, int levels) {
    q->levels = levels;
    q->queues = (Queue*) malloc(levels * sizeof(Queue));

    for(int i = 0; i < levels; i++) {
        Queue_init(&q->queues[i]);
    }
}

void PriorityQueue_enqueue(PriorityQueue *q, int n, int level) {
    if(level < 0 || level >= q->levels) {
        printf("Attempt to enqueue with invalid priority %d", level);
        return;
    }

    Queue_enqueue(&q->queues[level], n);
}

int PriorityQueue_dequeue(PriorityQueue *q) {
    for(int i = q->levels - 1; i >= 0; i--) {
        if(Queue_size(&q->queues[i]) != 0) {
            return Queue_dequeue(&q->queues[i]);
        }
    }

    printf("Attmept to dequeue from empty Priority Queue");
    return 0;
}

int PriorityQueue_size(PriorityQueue *q) {
    int sum = 0;

    for(int i = 0; i < q->levels; i++) {
        sum += Queue_size(&q->queues[i]);
    }

    return sum;
}
