package com.ckeyser.sorts

import com.ckeyser.util.SortUtil

import Ordering.Implicits._

/**
  * Created by Chris Keyser on 10/2/2016.
  */
object InsertionSort {
    def sort[A : Ordering](arr:Array[A]): Array[A] = {
        val out = arr.clone()

        for(i <- Range(1, out.length)) {
            var j = i

            while(j > 0 && out(j) > out(j - 1)) {
                SortUtil.swap(out, j, j - 1)
                j -= 1
            }
        }

        out
    }
}
