// aggregates all test functions into one file
#include <stdio.h>

#include "stack/stack_test.h"
#include "stack/queue_test.h"
#include "stack/priority_queue_test.h"
#include "sorts/sort_test.h"
#include "dictionary/dictionary_test.h"
#include "list/linkedlist_test.h"
#include "list/arraylist_test.h"

int main() {
    int passed = 0;
    int total = 0;

    Stack_test(&passed, &total);
    Queue_test(&passed, &total);
    PriorityQueue_test(&passed, &total);
    Dict_test(&passed, &total);
    Sort_test(&passed, &total);
    LinkedList_test(&passed, &total);
    ArrayList_test(&passed, &total);

    if(passed != total) {
        int failed = total - passed;

        printf("\n\n%d out of %d tests failed\n\n", failed, passed);

        return 1;
    } else {
        printf("\n\nOK -- %d tests ran\n\n", total);
        return 0;
    }
}
