#include "binary.h"

int Binary_search(int *arr, int l, int r, int n) {
    if(l >= r) {
        return -1;
    } else {
        int mid = (r + l) / 2;

        if(arr[mid] == n) {
            return mid;
        } else if(arr[mid] < n) {
            return Binary_search(arr, l, mid - 1, n);
        } else {
            return Binary_search(arr, mid + 1, r, n);
        }
    }
}
