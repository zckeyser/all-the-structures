#include "../util/swap.h"

void Selection_sort(int *arr, int length) {
    for(int i = 0; i < length; i++) {
        int min = i;

        for(int j = i + 1; j < length; j++) {
            if(arr[j] < arr[min]) {
                min = j;
            }
        }

        swap(arr, i, min);
    }
}
