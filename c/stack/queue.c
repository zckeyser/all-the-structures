#include <stdio.h>

#include "queue.h"

// array implementation of a queue

void Queue_init(Queue *q) {
    q->front = -1;
    q->rear = -1;
}

void Queue_enqueue(Queue *q, int n) {
    // if we're inserting our first item
    if(q->front == -1) {
        q->front = 0;
    }

    q->rear++;

    // roll over to the beginning of the array
    if(q->rear == QUEUE_MAX) {
        q->rear = 0;
    }

    // the queue is full, can't enqueue
    if(q->rear == q->front - 1) {
        printf("Queue overflow on inserting %d", n);
        return;
    }

    q->data[q->rear] = n;
}

int Queue_dequeue(Queue *q) {
    if(q->front == -1 || q->front == q->rear + 1) {
        printf("Queue underflow");
        return 0;
    }

    // value to return
    return q->data[q->front++];
}

int Queue_size(Queue *q) {
    if(q->front == -1 || q->front == q->rear + 1) {
        return 0;
    } else if(q->front > q->rear) {
        // we've overflowed and need to count things after front and before rear
        return (QUEUE_MAX - q->front) + (q->rear + 1);
    } else {
        return q->rear - q->front + 1;
    }
}
