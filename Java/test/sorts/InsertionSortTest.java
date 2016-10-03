package sorts;

import org.junit.Assert;
import org.junit.Test;
import util.SortUtil;
import util.TestUtil;

/**
 * Created by Chris Keyser on 10/3/2016.
 */
public class InsertionSortTest {
    @Test
    public void InsertionSort_SortsArray() {
        int arr[] = TestUtil.generateRandomArray(TestUtil.ARR_SIZE);

        int[] sorted = InsertionSort.sort(arr);

        Assert.assertTrue(SortUtil.isSorted(sorted));
    }
}
