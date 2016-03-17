package stack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris Keyser on 3/17/2016.
 * Simple queue implementation using generics and a list to represent the data
 * Handles I/O in FIFO order because it's a queue
 */
public class Queue<T> {
    private List<T> data;

    public Queue() {
        this.data = new ArrayList<>();
    }

    /**
     * pushes object onto back of queue
     */
    public void push(T obj) {
        this.data.add(obj);
    }

    /**
     * pops an object off the front of the queue
     */
    public T pop() {
        return !isEmpty() ? this.data.remove(0) : null;
    }

    /**
     * returns number of objects in queue
     */
    public int size() {
        return this.data.size();
    }

    /**
     * returns a boolean representing whether the queue is empty
     */
    public boolean isEmpty() {
        return this.data.isEmpty();
    }
}
