package stacks_and_queues;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris Keyser on 10/3/2016.
 *
 * implemented using multiple internal queues instead of a single queue
 * to improve efficiency when popping from queue
 */
public class PriorityQueue<T> {
    private List<Queue<T>> queues;

    public PriorityQueue(int levels) {
        queues = new ArrayList<>();

        for(int i = 0; i < levels; i++)
            queues.add(new Queue<>());
    }

    public void enqueue(T value, int level) {
        if(level < 0 || level >= queues.size())
            throw new IndexOutOfBoundsException();
        else
            queues.get(level).enqueue(value);
    }

    public T dequeue(T value) {
        for(int i = queues.size() - 1; i >= 0; i--)
            if(!queues.get(i).isEmpty())
                return queues.get(i).dequeue();

        return null;
    }

    public int size() {
        int size = 0;

        for(Queue<T> queue : queues)
            size += queue.size();

        return size;
    }

    public boolean isEmpty() {
        // check if any of the internal queues aren't empty
        for(Queue<T> queue : queues)
            if(!queue.isEmpty())
                return false;

        return true;
    }
}
