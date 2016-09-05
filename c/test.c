// aggregates all test functions into one file
#include <stdio.h>

#include "stack/stack_test.c"

int main() {
    int passed = 0;
    int total = 0;

    test_stack(&passed, &total);

    if(passed != total) {
        int failed = total - passed;

        printf("\n\n%d out of %d tests failed\n\n", &total, &passed);

        return 1;
    } else {
        printf("\n\nOK\n\n");
        return 0;
    }
}