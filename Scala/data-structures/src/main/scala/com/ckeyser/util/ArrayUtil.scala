package com.ckeyser.util

import scala.util.Random

/**
  * Created by Chris Keyser on 9/28/2016.
  */
object ArrayUtil {
    val DefaultSize = 1000

    def randomArray(len: Int) : Array[Int] = {
        val arr = Array[Int]()

        for(i <- Range(0, len))
          arr :+ Random.nextInt()

        arr
    }
}
