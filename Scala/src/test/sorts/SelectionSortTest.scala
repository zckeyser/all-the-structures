package sorts

import com.ckeyser.sorts.SelectionSort
import com.ckeyser.util.SortUtil
import org.scalatest.FunSpec
import util.TestUtil

/**
  * Created by Chris on 10/2/2016.
  */
class SelectionSortTest extends FunSpec {
    it("should correctly sort an array") {
        val arr = TestUtil.RandomArray(TestUtil.ARR_SIZE)

        val result = SelectionSort.sort(arr)

        assert(SortUtil.isSorted(result))
    }
}
