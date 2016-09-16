package searches.array;

import test.Test;

/**
 * Created by Chris Keyser on 3/17/2016.
 * test class for ArraySearch
 */
public class ArraySearchTest extends Test {
    @Override
    public void run() {
        int[] arr = {1, 2, 7, 10, 32, 59, 77, 89, 102, 310, 1240, 11404};

        expect("Linear search to find an existing value", ArraySearch.linearSearch(arr, 310));
        expect("Binary search to find an existing value over the median", ArraySearch.binarySearch(arr, 310));
        expect("Binary search to find an existing value under the median", ArraySearch.binarySearch(arr, 7));
        expect("Linear search to return false for non-existing values", !ArraySearch.linearSearch(arr, 124));
        expect("Binary search to return false for non-existing values", !ArraySearch.binarySearch(arr, 450));
    }
}
