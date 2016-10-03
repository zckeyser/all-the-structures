package searches;

import java.util.Arrays;

/**
 * Created by Chris Keyser on 10/3/2016.
 */
public class BinarySearch {
    /**
     * binary search implementation
     * works on assumption that array is sorted
     * does not work on unsorted arrays
     * O(log(n)) efficiency
     */
    public static boolean contains(int[] arr, int n) {
        int testIndex = arr.length / 2;

        if(arr[testIndex] == n) {
            return true;
        }

        if (arr.length == 1) {
            return false;
        }

        return n < arr[testIndex] ?
                contains(Arrays.copyOfRange(arr, 0, arr.length / 2), n) : // search front half of array
                contains(Arrays.copyOfRange(arr, testIndex + 1, arr.length), n); //search back half of array
    }
}
