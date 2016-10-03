package sorts;

import util.SortUtil;

/**
 * Created by Chris Keyser on 3/17/2016.
 * Bubble sort implementation
 */
public class BubbleSort {
    public static int[] sort(int[] arr) {
        while(!SortUtil.isSorted(arr)) {
            for(int i = 0; i < arr.length - 1; i++) {
                if(arr[i] > arr[i + 1]) {
                    SortUtil.swap(arr, i, i + 1);
                }
            }
        }

        return arr;
    }
}
