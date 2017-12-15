#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#include "bfs.h"
#include "../stack/queue.h"
#include "../util/sb.h"

char* BreadthFirst_traversal(int **graph, int length, int start) {
    Queue *q = malloc(sizeof(Queue));
    Queue_init(q);
    Queue_enqueue(q, start);

    StringBuilder *sb = malloc(sizeof(StringBuilder));
    StringBuilder_init(sb);

    int visited[length];

    for(int i = 0; i < length; i++) {
        visited[i] = 0;
    }

    while(Queue_size(q) != 0) {
        int current = Queue_dequeue(q);
        visited[current] = 1;

        // add neighbors to queue
        for(int i = 0; i < length; i++) {
            int edge = graph[current][i];

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
    // remove trailing whitespace
    out[strlen(out) - 1] = '\0';
    
    free(q);
    free(sb);

    return out;
}
