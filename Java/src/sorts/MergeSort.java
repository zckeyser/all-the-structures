package sorts;

import java.util.Arrays;

/**
 * Created by Chris Keyser on 3/17/2016.
 * mergesort implementation
 */
public class MergeSort extends Sort {
    public MergeSort(int[] arr) {
        this.arr = arr;
    }

    @Override
    public int[] sort() {
        arr = mergesort(arr);
        return new int[0];
    }

    /**
     * sorts given array using mergesort
     */
    private int[] mergesort(int[] array) {
        if(array.length == 1) {
            return array;
        }

        int[] frontHalf = Arrays.copyOfRange(array, 0, array.length / 2);
        int[] backHalf = Arrays.copyOfRange(array, array.length / 2, array.length);

        return merge(mergesort(frontHalf), mergesort(backHalf));
    }

    /**
     * merges two sorted arrays into a larger sorted array
     */
    private int[] merge(int[] a, int[] b) {
        int i = 0, j = 0, pos = 0;
        int[] result = new int[a.length + b.length];

        while(i < a.length || j < b.length) {
            if(i == a.length) {
                result[pos] = b[j];
                j++;
            } else if(j == b.length) {
                result[pos] = a[i];
                i++;
            } else if(a[i] < b[j]) {
                result[pos] = a[i];
                i++;
            } else {
                result[pos] = b[j];
                j++;
            }

            pos++;
        }

        return result;
    }
}
