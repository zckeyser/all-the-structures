#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#include "bfs_test.h"
#include "bfs.h"
#include "../test/assert.h"

void BreadthFirst_test(int *passed, int *total) {
    printf("\n\nBreadth First Search\n\n");

    /**
    * adjacency graph is as follows
    { 0, 1, 0, 1, 1 }
    { 0, 0, 0, 1, 0 }
    { 0, 0, 0, 0, 0 }
    { 0, 0, 1, 0, 0 }
    { 0, 1, 0, 0, 0 }
    */
    int **test = malloc(sizeof(int*) * 5);

    for(int i = 0; i < 5; i++) {
        test[i] = malloc(sizeof(int) * 5);

        for(int j = 0; j < 5; j++) {
            test[i][j] = 0;
        }
    }

    test[0][1] = 1;
    test[0][3] = 1;
    test[0][4] = 1;
    test[1][3] = 1;
    test[3][2] = 1;
    test[4][1] = 1;

    char *result = BreadthFirst_traversal(test, 5, 0);

    *passed += ASSERT_STR_EQUALS("0 1 3 4 2", result, "Breadth First Traversal");
    *total += 1;
}
