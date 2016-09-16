#include <stclib.h>
#include <stdio.h>
#include <string.h>

#include "bfs.h"
#include "../stack/queue.h"

void BreadthFirst_traversal(char *out, int graph[][], int length, int start) {
    Queue q = malloc(sizeof(Queue));
    Queue_init(q);
    Queue_enqueue(start);

    char *result = malloc((sizeof(char) * length * 10) + 1);
    result[0] = '\0';

    int visited[length];

    while(Queue_size != 0) {
        int current = Queue_dequeue(row);
        visited[current] = 1;

        // add neighbors to queue
        for(int i = 0; i < length; i++) {
            if(graph[current][i] && !visited[i]) {
                visited[i] = 1;
                Queue_enqueue(i);
            }
        }

        // add to output
        char val[10];
        sprintf(val, "%d ", current);

        strcat(result, val);

        free(val);
    }

    out = realloc(out, sizeof(char) * strlen(result));
    strcpy(out, result);

    free(q);
    free(result);
    free(visited);
}
