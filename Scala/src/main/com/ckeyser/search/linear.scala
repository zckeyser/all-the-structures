package com.ckeyser.search

object LinearSearch {
    def indexOf[A](arr: Array[A], target: A): Int = {
        for(i <- arr.indices) {
            if(target.equals(arr(i))) {
                return i;
            }
        }

        -1
    }
}
