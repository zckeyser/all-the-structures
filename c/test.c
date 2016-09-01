// aggregates all test functions into one file
#include <stdio.h>

#include "stack/stack_test.c"
#include "test/assert.h"

int main() {
    TestResult overall;
    overall.passed = 0;
    overall.total = 0;

    TestResult result;

    result = test_stack();
    overall.passed += result.passed;
    overall.total += result.total;


    if(overall.passed != overall.total) {
        int failed = overall.total - overall.passed;

        printf("\n\n%d out of %d tests failed\n\n", &overall.total, &overall.passed);

        return 1;
    } else {
        printf("\n\nOK\n\n");
        return 0;
    }
}
