#include <stdlib.h>

// returns a value in the range [0, n)
int randint(int max) {
    if ((max - 1) == RAND_MAX) {
        return rand();
    } else {
        return rand() % max;
    }
}
