#include "bubble.h"

#include "../util/swap.h"
#include "issorted.h"

void Bubble_sort(int *arr, int length) {
    while(issorted(arr, length) != 1) {
        for(int i = 0; i < length - 1; i++) {
            if(arr[i] > arr[i + 1]) {
                swap(arr, i, i + 1);
            }
        }
    }
}
