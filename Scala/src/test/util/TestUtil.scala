package util

import scala.util.Random

/**
  * Created by Chris Keyser on 10/2/2016.
  */
object TestUtil {
    val ARR_SIZE = 1000

    def RandomArray(len: Int): Array[Int] = {
        val arr = Array[Int]()
        val rand = new Random()

        for(i <- Range(0, len)) {
            arr :+ rand.nextInt()
        }

        arr
    }
}
