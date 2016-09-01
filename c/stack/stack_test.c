#include <stdio>
#include "stack.h"
#include "../test/assert.h"

TestResult test_stack() {
    TestResult result;
    result.passed = 0;
    result.total = 0;

    result.passed += ASSERT_EQUALS(0, size(), "size should initialize to 0");
    result.total++;

    push(10);

    result.passed += ASSERT_EQUALS(1, size(), "size should be 1 after initial push");
    result.total++;

    push(20);

    result.passed += ASSERT_EQUALS(2, size(), "size should be 2 after second push");
    result.total++;

    int result = pop();

    result.passed += ASSERT_EQUALS(20, result, "should return most recently pushed item");
    result.total++;

    result = pop();

    result.passed += ASSERT_EQUALS(10, result, "should return second most recently pushed item");
    result.total++;

    return result;
}
