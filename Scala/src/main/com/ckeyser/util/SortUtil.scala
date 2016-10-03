package com.ckeyser.util

import Ordering.Implicits._

/**
  * Created by Chris on 9/28/2016.
  */
object SortUtil {
    def isSorted[A : Ordering](arr: Array[A]): Boolean = {
        for(i <- Range(0, arr.length - 1))
            if(arr(i) > arr(i + 1))
                false

        true
    }

    def swap[A](arr: Array[A], i: Int, j: Int): Unit = {
        val tmp = arr(i)
        arr(i) = arr(j)
        arr(j) = tmp
    }
}
