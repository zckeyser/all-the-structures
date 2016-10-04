#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#include "bfs.h"
#include "../stack/queue.h"
#include "../util/sb.h"

char* BreadthFirst_traversal(int *graph, int length, int start) {
    Queue *q = malloc(sizeof(Queue));
    Queue_init(q);
    Queue_enqueue(q, start);

    StringBuilder *sb = malloc(sizeof(StringBuilder));
    StringBuilder_init(sb);

    int visited[length];

    while(Queue_size(q) != 0) {
        int current = Queue_dequeue(q);
        visited[current] = 1;

        // add neighbors to queue
        for(int i = 0; i < length; i++) {
            // since we can't pass a 2d array normally
            // we need to use pointer arithmetic instead
            int edge = *((graph + current * length) + i);

            if(edge && !visited[i]) {
                visited[i] = 1;
                Queue_enqueue(q, i);
            }
        }

        // add to output
        char val[11];
        sprintf(val, "%d ", current);

        StringBuilder_append(sb, val);
    }

    char* out = StringBuilder_build(sb);

    free(q);
    free(sb);
    free(visited);

    return out;
}
