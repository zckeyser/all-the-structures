#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#include "bfs.h"
#include "../stack/queue.h"

void BreadthFirst_traversal(char *out, int *graph, int length, int start) {
    Queue *q = malloc(sizeof(Queue));
    Queue_init(q);
    Queue_enqueue(q, start);

    char *result = malloc((sizeof(char) * length * 10) + 1);
    result[0] = '\0';

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
        char val[10];
        sprintf(val, "%d ", current);

        strcat(result, val);
    }

    out = realloc(out, sizeof(char) * strlen(result));
    strcpy(out, result);

    free(q);
    free(result);
    free(visited);
}
