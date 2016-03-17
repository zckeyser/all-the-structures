package searches;

import java.util.Arrays;

/**
 * Created by Chris Keyser on 3/17/2016.
 * contains implementation of both naive search and binary search
 */
public class ArraySearch {
    /**
     * naive search implementation
     * works on any array but is slow
     * O(n) efficiency
     */
    public static boolean naiveSearch(int[] arr, int n) {
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] == n) {
                return true;
            }
        }

        return false;
    }

    /**
     * binary search implementation
     * works on assumption that array is sorted
     * does not work on unsorted arrays
     * O(log(n)) efficiency
     */
    public static boolean binarySearch(int[] arr, int n) {
        int testIndex = arr.length / 2;

        if(arr[testIndex] == n) {
            return true;
        }

        if (arr.length == 1) {
            return false;
        }

        return n < arr[testIndex] ?
                    binarySearch(Arrays.copyOfRange(arr, 0, arr.length / 2), n) : // search front half of array
                    binarySearch(Arrays.copyOfRange(arr, testIndex + 1, arr.length), n); //search back half of array
    }
}
