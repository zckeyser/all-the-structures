package com.ckeyser.sorts

import Ordering.Implicits._
import com.ckeyser.util.SortUtil

/**
  * Created by Chris Keyser on 9/28/2016.
  */
object BubbleSort {
    def sort[A : Ordering](arr: Array[A]): Array[A] = {
        val out = arr.clone()

        while(!SortUtil.isSorted(out))
            for(i <- Range(0, out.length - 1))
              if(arr(i) > arr(i + 1))
                SortUtil.swap(arr, i, i + 1)

        arr
    }
}
