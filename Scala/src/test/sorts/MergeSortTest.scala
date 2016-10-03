package sorts

import com.ckeyser.sorts.MergeSort
import com.ckeyser.util.SortUtil
import org.scalatest.FunSpec
import util.TestUtil

import scala.reflect.ClassTag

/**
  * Created by Chris on 10/2/2016.
  */
class MergeSortTest extends FunSpec{
    it("should correctly sort an array") {
        val arr = TestUtil.RandomArray(TestUtil.ARR_SIZE)

        val result = MergeSort.mergesort(arr)

        assert(SortUtil.isSorted(result))
    }
}
