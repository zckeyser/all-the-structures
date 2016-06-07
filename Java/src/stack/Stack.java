package stack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris Keyser on 3/17/2016.
 * simple generic stack implementation using a List as a base data structure to avoid tedious resizing of an array
 * Handles I/O in LIFO order because it's a stack
 */
public class Stack<T> {
    private List<T> data;

    public Stack() {
        this.data = new ArrayList<>();
    }

    /**
     * initializes stack with data in the order of given list
     */
    public Stack(List<T> data) {
        this.data = new ArrayList<>(data);
    }

    /**
     * pushes object onto top of stack
     */
    public void push(T obj) {
        this.data.add(obj);
    }

    /**
     * pops an object off the top of the stack
     */
    public T pop() {
        return !isEmpty() ? this.data.remove(data.size() - 1) : null;
    }

    /**
     * returns number of objects on stack
     */
    public int size() {
        return this.data.size();
    }

    /**
     * returns a boolean representing whether the stack is empty
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
