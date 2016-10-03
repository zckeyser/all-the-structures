package stacks_and_queues;

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
     * initializes Queue to have information in the order of given List
     */
    public Queue(List<T> data) {
        this.data = new ArrayList<>(data);
    }

    /**
     * pushes object onto back of queue
     */
    public void enqueue(T obj) {
        this.data.add(obj);
    }

    /**
     * pops an object off the front of the queue
     */
    public T dequeue() {
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

    /**
     * determines whether the queue contains object obj
     */
    public boolean contains(T obj) {
        return data.contains(obj);
    }
}
