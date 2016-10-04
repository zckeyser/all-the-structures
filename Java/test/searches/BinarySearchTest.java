package searches;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Chris Keyser on 10/3/2016.
 */
public class BinarySearchTest {
    private static int[] arr;

    @BeforeClass
    public static void setUp() {
        arr = new int[] {1, 2, 7, 10, 32, 59, 77, 89, 102, 310, 1240, 11404};
    }

    @Test
    public void BinarySearch_Contains_Positive_TopHalf() {
        Assert.assertTrue("Binary search to find an existing value over the median", BinarySearch.contains(arr, 310));
    }

    @Test
    public void BinarySearch_Contains_Positive_BottomHalf() {
        Assert.assertTrue("Binary search to find an existing value under the median", BinarySearch.contains(arr, 7));
    }

    @Test
    public void BinarySearch_Contains_Negative() {
        Assert.assertFalse("Binary search to return false for non-existing values", BinarySearch.contains(arr, 450));
    }
}
