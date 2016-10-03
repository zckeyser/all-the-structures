package sorts;

import org.junit.Assert;
import org.junit.Test;
import util.SortUtil;
import util.TestUtil;

/**
 * Created by Chris Keyser on 10/3/2016.
 */
public class MergeSortTest {
    @Test
    public void MergeSort_SortsCorrectly() {
        int arr[] = TestUtil.generateRandomArray(TestUtil.ARR_SIZE);

        int[] sorted = MergeSort.sort(arr);

        Assert.assertTrue(SortUtil.isSorted(sorted));
    }
}
