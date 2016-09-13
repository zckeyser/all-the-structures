#include <stdio.h>
#include <stdlib.h>

#include "priority_queue_test.h"
#include "priority_queue.h"
#include "../test/assert.h"

void PriorityQueue_test(int *passed, int *total) {
    printf("\n\nPriority Queue\n\n");

    PriorityQueue *q = malloc(sizeof(PriorityQueue));

    // initialize with 5 priority levels
    PriorityQueue_init(q, 5);

    *passed += ASSERT_INT_EQUALS(0, PriorityQueue_size(q), "Priority Queue is empty on init");
    *total += 1;

    // add to each level in reverse order,
    // to make sure the levels are being respected when withdrawing
    PriorityQueue_enqueue(q, 5, 0);
    PriorityQueue_enqueue(q, 10, 0);
    PriorityQueue_enqueue(q, 15, 1);
    PriorityQueue_enqueue(q, 20, 1);
    PriorityQueue_enqueue(q, 25, 2);
    PriorityQueue_enqueue(q, 30, 2);
    PriorityQueue_enqueue(q, 35, 2);
    PriorityQueue_enqueue(q, 40, 3);

    // verify dequeue order + size reduction
    int result[8];
    int expected[] = { 40, 25, 30, 35, 15, 20, 5, 10 };

    for(int i = 0; i < 8; i++) {
        result[i] = PriorityQueue_dequeue(q);
        *passed += ASSERT_INT_EQUALS(7 - i, PriorityQueue_size(q), "check size after dequeue");
        *total += 1;
    }

    *passed += ASSERT_ARR_EQUALS(expected, result, "verify dequeue order", 8);
    *total += 1;
}
