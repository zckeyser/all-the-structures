#include "linear.h"

int Linear_search(int *arr, int l, int n) {
    for(int i = 0; i < l; i++) {
        if(arr[i] == n) {
            return i;
        }
    }

    return -1;
}
