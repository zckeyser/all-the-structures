#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#include "bfs_test.h"
#include "bfs.h"
#include "../test/assert.h"

void BreadthFirst_test(int *passed, int *total) {
    printf("\n\nBreadth First Search\n\n");

    int test[5][5] = {
        { 0, 1, 0, 1, 1 },
        { 0, 0, 0, 1, 0 },
        { 0, 0, 0, 0, 0 },
        { 0, 0, 1, 0, 0 },
        { 0, 1, 0, 0, 0}
    };

    char *result = malloc(sizeof(char) * 5);

    BreadthFirst_traversal(result, (int *)test, 5, 0);

    *passed += ASSERT_STR_EQUALS("0 1 3 4 2", result, "Breadth First Traversal");
    *total += 1;
}
