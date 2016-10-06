package search

import com.ckeyser.search.BinarySearch
import org.scalatest.FunSpec

/**
  * Created by Chris Keyser on 10/6/2016.
  */
class BinarySearchTest extends FunSpec {
    it("should not find an uncontained element") {
        val array = Range(0, 100).toArray

        assert(BinarySearch.indexOf(array, 1000) == -1)
    }

    it("should find a contained element at the beginning of the array") {
        val array = Range(0, 100).toArray

        assert(BinarySearch.indexOf(array, 0) == 0)
    }

    it("should find a contained element in the lower quartile") {
        val array = Range(0, 100).toArray

        assert(BinarySearch.indexOf(array, 17) == 17)
    }

    it("should find a contained element in the middle of the array") {
        val array = Range(0, 100).toArray

        assert(BinarySearch.indexOf(array, 50) == 50)
    }

    it("should find a contained element in the upper quartile") {
        val array = Range(0, 100).toArray

        assert(BinarySearch.indexOf(array, 83) == 83)
    }

    it("should find a contained element at the end of the array") {
        val array = Range(0, 100).toArray

        assert(BinarySearch.indexOf(array, 99) == 99)
    }
}
