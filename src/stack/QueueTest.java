package stack;

import test.Test;

/**
 * Created by Chris Keyser on 3/17/2016.
 * Tests for Queue class
 */
public class QueueTest extends Test {
    @Override
    public void run() {
        Queue<Integer> queue = new Queue<>();

        expect("Queue to be empty on initialization", queue.isEmpty());
        expectEquals("Queue to have size 0 on initialization", queue.size(), 0);

        queue.push(5);
        queue.push(11);

        expectEquals("Queue to have correct size after adding two elements", queue.size(), 2);

        //test pop
        Integer testVal = queue.pop();
        Integer expected = 5;

        expectEquals("The right element to be pulled from the queue", testVal, expected);
        expectEquals("The size of Queue to decrease by 1 after pop", queue.size(), 1);
    }
}
