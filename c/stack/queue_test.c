#include <stdio.h>

#include "queue.h"
#include "../test/assert.h"

void Queue_test(int *passed, int *total) {
    printf("\n\nQueue\n\n");
    Queue q;
    Queue_init(&q);

    *passed += ASSERT_INT_EQUALS(0, Queue_size(&q), "Queue is initialized to be empty");
    *total += 1;

    Queue_enqueue(&q, 10);

    *passed += ASSERT_INT_EQUALS(1, Queue_size(&q), "Queue is correct size after first enqueue");
    *total += 1;

    Queue_enqueue(&q, 20);

    *passed += ASSERT_INT_EQUALS(2, Queue_size(&q), "Queue is correct size after second enqueue");
    *total += 1;

    int result = Queue_dequeue(&q);

    *passed += ASSERT_INT_EQUALS(10, result, "Queue dequeues correct item first");
    *total += 1;

    result = Queue_dequeue(&q);

    *passed += ASSERT_INT_EQUALS(20, result, "Queue dequeues correct item second");
    *total += 1;

    *passed += ASSERT_INT_EQUALS(0, Queue_size(&q), "Queue is empty after all items are dequeued");
    *total += 1;
}
