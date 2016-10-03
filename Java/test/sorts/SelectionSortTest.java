package sorts;

import org.junit.Assert;
import org.junit.Test;
import util.SortUtil;
import util.TestUtil;

/**
 * Created by Chris Keyser on 10/3/2016.
 */
public class SelectionSortTest {
    @Test
    public void SelectionSort_SortsCorrectly() {
        int arr[] = TestUtil.generateRandomArray(TestUtil.ARR_SIZE);

        int[] sorted = SelectionSort.sort(arr);

        Assert.assertTrue(SortUtil.isSorted(sorted));
    }
}
