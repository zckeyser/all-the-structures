#include <stdio.h>

#include "quick.h"

#include "swap.h"

int partition(int *arr, int left, int right);

void Quick_sort(int *arr, int left, int right) {
    if(left < right) {
        int index = partition(arr, left, right);

        Quick_sort(arr, left, index - 1);
        Quick_sort(arr, index + 1, right);
    }
}

int partition(int *arr, int left, int right) {
    int pivot = arr[left];

    int i = left, j = right + 1;

    // partition
    while(1) {
        do ++i; while(arr[i] <= pivot && i <= right);
        do --j; while(arr[j] > pivot);

        if(i >= j) break;

        swap(arr, i, j);
    }

    // move the pivot into the center
    swap(arr, left, j);

    return j;
}
