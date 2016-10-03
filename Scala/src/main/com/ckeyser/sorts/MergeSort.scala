package com.ckeyser.sorts

/**
  * Created by Chris on 10/2/2016.
  */
object MergeSort {
    // due to difficulties with getting ClassTag to work for generics,
    // I'm just using Int here
    def mergesort(arr: Array[Int]): Array[Int] = {
        if(arr.length <= 1) {
            return arr
        }

        val mid = arr.length / 2

        merge(mergesort(arr.slice(0, mid)), mergesort(arr.slice(mid, arr.length)))
    }

    def merge(a: Array[Int], b: Array[Int]): Array[Int] = {
        val out = Array[Int]()

        var i, j = 0

        while(i < a.length && j < b.length) {
            // add the next smallest available element
            if(a(i) < b(j)) {
                out :+ a(i)
                i += 1
            } else {
                out :+ b(j)
                j += 1
            }
        }

        // add the rest of a
        while(i < a.length) {
            out :+ a(i)
            i += 1
        }

        // add the rest of b
        while(j < b.length) {
          out :+ b(j)
          j += 1
        }

        out
    }
}
