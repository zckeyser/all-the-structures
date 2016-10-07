package com.ckeyser.list

/**
  * Created by Chris Keyser on 10/6/2016.
  */
class LinkedList[A](var data: A, var next: Option[LinkedList[A]]) {
    def append(item: A): Unit = {
        if(next.isDefined) {
            next.get.append(item)
        } else {
            next = Option(new LinkedList[A](data, None))
        }
    }

    def insert(item: A, index: Int): Unit = {
        if(index == 0) {
            data = item
        } else if (index == 1) {

        }
    }

    def set(item: A, index: Int): Unit = {

    }

    def get(index: Int): A = {

    }

    def remove(index: Int): LinkedList[A] = {

    }
}
