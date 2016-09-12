#include <stdlib.h>

#include "merge.h"

void merge(int *src, int *a, int *b, int alen, int blen);

void Merge_sort(int *arr, int length) {
    if(length < 2) return; // base condition

    int mid, *left, *right;

    mid = length / 2;

    // create subarrays
    left = (int*) malloc(mid * sizeof(int));
    right = (int*) malloc((length - mid) * sizeof(int));

    for(int i = 0; i < mid; i++) left[i] = arr[i];
    for(int i = mid; i < length; i++) right[i - mid] = arr[i];

    Merge_sort(left, mid);
    Merge_sort(right, length - mid);

    merge(arr, left, right, mid, length - mid);
    free(left);
    free(right);
}

void merge(int *src, int *a, int *b, int alen, int blen) {
    int i = 0;
    int j = 0;

    while(i < alen || j < blen) {
        int index = i + j;

        if(i == alen) {
            src[index] = b[j];
            j++;
        } else if(j == blen) {
            src[index] = a[i];
            i++;
        } else if(a[i] < b[j]) {
            src[index] = a[i];
            i++;
        } else {
            src[index] = b[j];
            j++;
        }
    }
}
