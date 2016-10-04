package searches;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Chris Keyser on 10/3/2016.
 */
public class LinearSearchTest {
    private static int[] arr;

    @BeforeClass
    public static void setUp() {
        arr = new int[] {1, 2, 7, 10, 32, 59, 77, 89, 102, 310, 1240, 11404};
    }

    @Test
    public void LinearSearch_Contains_Positive() {
        Assert.assertTrue("Linear search to find an existing value", LinearSearch.contains(arr, 310));
    }

    @Test
    public void LinearSearch_Contains_Negative() {
        Assert.assertFalse("Linear search to return false for non-existing values", LinearSearch.contains(arr, 124));
    }
}
