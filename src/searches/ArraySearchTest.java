package searches;

import test.Test;

/**
 * Created by Chris Keyser on 3/17/2016.
 * test class for ArraySearch
 */
public class ArraySearchTest extends Test {
    @Override
    public void run() {
        int[] arr = {1, 2, 7, 10, 32, 59, 77, 89, 102, 310, 1240, 11404};

        expect(ArraySearch.naiveSearch(arr, 310));
        expect(ArraySearch.binarySearch(arr, 310));
        expect(ArraySearch.binarySearch(arr, 7));
        expect(!ArraySearch.naiveSearch(arr, 124));
        expect(!ArraySearch.binarySearch(arr, 450));
    }
}
