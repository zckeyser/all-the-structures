package sorts;

import util.SortUtil;
/**
 * Created by Chris Keyser on 3/17/2016.
 * Insertion sort implementation
 */
public class InsertionSort {
    public static int[] sort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                SortUtil.swap(arr, j, j - 1);
            }
        }

        return arr;
    }
}
