package com.ckeyser.search

import Ordering.Implicits._

/**
  * Created by Chris Keyser on 10/6/2016.
  *
  * recursive binary search implementation
  */
object BinarySearch {
    def indexOf[A : Ordering](arr: Array[A], target: A): Int = {
        search(arr, target, 0, arr.length - 1)
    }

    private def search[A: Ordering](arr: Array[A], target: A, left: Int, right: Int): Int = {
        if(left > right) return -1

        val mid = (left + right) / 2

        if(target < arr(mid)) {
            return search(arr, target, left, mid - 1)
        }

        if(target > arr(mid)) {
            return search(arr, target, mid + 1, right)
        }

        return mid
    }
}