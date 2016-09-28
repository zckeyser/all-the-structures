package sorts

import com.ckeyser.sorts.BubbleSort
import org.scalatest.FunSpec
import com.ckeyser.util.{ArrayUtil, SortUtil}

/**
  * Created by Chris Keyser on 9/28/2016.
  */
class BubbleSortTest extends FunSpec {
    it("should correctly sort an array") {
        val input = ArrayUtil.randomArray(ArrayUtil.DefaultSize)

        val result = BubbleSort.sort(input)

        assert(SortUtil.isSorted(result))
    }
}
