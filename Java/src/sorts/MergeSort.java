package sorts;

import java.util.Arrays;

/**
 * Created by Chris Keyser on 3/17/2016.
 * mergesort implementation
 */
public class MergeSort {
    public static int[] sort(int[] arr) {
        if(arr.length == 1) {
            return arr;
        }

        int[] frontHalf = Arrays.copyOfRange(arr, 0, arr.length / 2);
        int[] backHalf = Arrays.copyOfRange(arr, arr.length / 2, arr.length);

        return merge(sort(frontHalf), sort(backHalf));
    }

    /**
     * merges two sorted arrays into a larger sorted array
     */
    private static int[] merge(int[] a, int[] b) {
        int i = 0, j = 0;
        int merged[] = new int[a.length + b.length];

        while(i < a.length && j < b.length) {
            if(a[i] < b[j]) {
                merged[i + j] = a[i];
                i++;
            } else {
                merged[i + j] = b[j];
                j++;
            }
        }

        while(i < a.length) {
            merged[i + j] = a[i];
            i++;
        }

        while(j < b.length) {
            merged[i + j] = b[j];
            j++;
        }

        return merged;
    }
}
