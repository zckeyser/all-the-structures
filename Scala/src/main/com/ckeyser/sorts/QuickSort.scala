package com.ckeyser.sorts

/**
  * Created by Chris on 10/2/2016.
  * qsort using list comprehensions
  */
object QuickSort {
    def sort(arr: Array[Int]): Array[Int] = {
        if(arr.length == 0) return arr

        val left = sort(for(x <- arr if x < arr(0)) yield x)
        val center = for(x <- arr if x == arr(0)) yield x
        val right = sort(for(x <- arr if x > arr(0)) yield x)

        return left ++ center ++ right
    }
}
