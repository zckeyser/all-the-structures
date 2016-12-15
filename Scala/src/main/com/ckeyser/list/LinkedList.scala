package com.ckeyser.list

/**
  * Created by Chris Keyser on 10/6/2016.
  *
  * immutable linked list
  */
class LinkedList[A](val data: A, val next: Option[LinkedList[A]]) {
    def append(item: A): LinkedList[A] = {
        if(next.isDefined) {
            next.get.append(item)
        } else {
            // return an equivalent of this node with the new node as next
            new LinkedList[A](data, Option(new LinkedList[A](item, None)))
        }
    }

    def insert(item: A, index: Int): Unit = {
        if(index == 0) {
            // set this as the given value, and put the current node as the next node
            new LinkedList[A](item, Option(new LinkedList[A](data, next)))
        } else if (index == 1) {
            new LinkedList[A](data, Option(new LinkedList[A](item, next)))
        } else {
            if(next.isEmpty)
                throw new IndexOutOfBoundsException // the given index is after the end of the list
            else
                next.get.insert(item, index - 1)
        }
    }

    def set(item: A, index: Int): LinkedList[A] = {
        // negative indexes are invalid
        if(index < 0) throw IndexOutOfBoundsException
        // we've reached the node, set it to the value
        if(index == 0) return new LinkedList[A](item, next)

        if(next.isDefined)
            next.get.set(item, index - 1)
        else
            throw IndexOutOfBoundsException // the index is past the end of the list
    }

    def get(index: Int): A = {
        if(index < 0) throw IndexOutOfBoundsException
        if(index == 0) return data

        if(next.isDefined)
            next.get.get(index - 1)
        else
            throw IndexOutOfBoundsException
    }

    def remove(index: Int): Option[LinkedList[A]] = {
        if(index == 0) return next
        if(index == 1) {
            if(next.isDefined) {
                return Option(new LinkedList[A](data, next.get.next))
            } else {
                throw IndexOutOfBoundsException // went past the end of the list
            }
        }

        if(next.isDefined) {
            next.get.remove(index - 1)
        } else {
            throw IndexOutOfBoundsException // went past the end of the list
        }
    }
}
