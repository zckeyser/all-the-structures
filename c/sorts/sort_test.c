#define TEST_ARR_SIZE 1000

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#include "sort_test.h"

#include "../test/assert.h"
#include "../util/randint.h"
#include "swap.h"
#include "issorted.h"
#include "bubble.h"
#include "insertion.h"
#include "selection.h"
#include "merge.h"
#include "quick.h"

void shuffle(int arr[], int length);

void Sort_test(int *passed, int *total) {
    printf("\n\nSorts\n\n");

    srand(time(NULL));

    int input[TEST_ARR_SIZE];

    for(int i = 0; i < TEST_ARR_SIZE; i++) {
        input[i] = rand();
    }

    Bubble_sort(input, TEST_ARR_SIZE);

    *passed += ASSERT_TRUE(issorted(input, TEST_ARR_SIZE), "Bubble Sort");
    *total += 1;

    shuffle(input, TEST_ARR_SIZE);
    Insertion_sort(input, TEST_ARR_SIZE);

    *passed += ASSERT_TRUE(issorted(input, TEST_ARR_SIZE), "Insertion Sort");
    *total += 1;

    shuffle(input, TEST_ARR_SIZE);
    Selection_sort(input, TEST_ARR_SIZE);

    *passed += ASSERT_TRUE(issorted(input, TEST_ARR_SIZE), "Selection Sort");
    *total += 1;

    shuffle(input, TEST_ARR_SIZE);
    Merge_sort(input, TEST_ARR_SIZE);

    *passed += ASSERT_TRUE(issorted(input, TEST_ARR_SIZE), "Merge Sort");
    *total += 1;

    shuffle(input, TEST_ARR_SIZE);
    Quick_sort(input, 0, TEST_ARR_SIZE - 1);

    *passed += ASSERT_TRUE(issorted(input, TEST_ARR_SIZE), "Quick Sort");
    *total += 1;
}

void shuffle(int arr[], int length) {
    for(int i = 0; i < length; i++) {
        int j = randint(length);

        swap(arr, i, j);
    }
}
