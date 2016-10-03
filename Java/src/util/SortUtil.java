package util;

/**
 * Created by Chris Keyser on 10/3/2016.
 */
public class SortUtil {
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * checks to see if an array is sorted
     */
    public static boolean isSorted(int[] arr) {
        for(int i = 0; i < arr.length - 2; i++) {
            if(arr[i] < arr[i + 1]) {
                return false;
            }
        }

        return true;
    }
}
