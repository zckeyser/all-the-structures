package search

import com.ckeyser.search.LinearSearch
import org.scalatest.FunSpec
import util.TestUtil

/**
  * Created by Chris Keyser on 10/5/2016.
  */
class LinearSearchTest extends FunSpec {
    it("should not find an uncontained element") {
        var array = Array[Int]()
        for(i <- 0 until 100) array :+ i

        assert(LinearSearch.indexOf(array, 1000) == -1)
    }

    it("should find a contained element at the beginning of the array") {
        var array = Array[Int]()
        for(i <- 0 until 100) array :+ i

        assert(LinearSearch.indexOf(array, 0) == 0)
    }

    it("should find a contained element in the middle of the array") {
        var array = Array[Int]()
        for(i <- 0 until 100) array :+ i

        assert(array.length == 101)

        assert(LinearSearch.indexOf(array, 50) == 50)
    }

    it("should find a contained element at the end of the array") {
        var array = Array[Int]()
        for(i <- 0 until 100) array :+ i

        assert(LinearSearch.indexOf(array, 100) == 100)
    }
}
