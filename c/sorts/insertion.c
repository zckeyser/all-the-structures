#include "swap.h"

void Insertion_sort(int *arr, int length) {
    for(int i = 1; i < length; i++) {
        int j = i;

        while(j > 0 && arr[j - 1] > arr[j]) {
            swap(arr, j, j - 1);
            j--;
        }
    }
}
