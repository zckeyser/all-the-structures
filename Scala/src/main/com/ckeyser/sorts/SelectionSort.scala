package com.ckeyser.sorts

import com.ckeyser.util.SortUtil

import Ordering.Implicits._

/**
  * Created by Chris Keyser on 10/2/2016.
  */
object SelectionSort {
    def sort[A : Ordering](arr: Array[A]): Array[A] = {
        val out = arr.clone()

        for(i <- out.indices) {
            var min = Int.MaxValue
            // find the next lowest element
            for(j <- Range(i, out.length)) {
                min = if (out(j) < out(min)) j else min
            }

            SortUtil.swap(out, min, i)
        }

        out
    }
}
