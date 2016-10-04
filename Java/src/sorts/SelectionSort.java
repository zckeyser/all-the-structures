package sorts;

import util.SortUtil;

/**
 * Created by Chris Keyser on 3/17/2016.
 * Selection sort implementation
 */
public class SelectionSort {
    public static int[] sort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int min = i;

            for(int j = i; j < arr.length; j++) {
                if(arr[j] < arr[min]) {
                    min = j;
                }
            }

            SortUtil.swap(arr, i, min);
        }

        return arr;
    }
}
