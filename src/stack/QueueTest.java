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

        //test isEmpty and size with no data on queue
        expect(queue.isEmpty());
        expectEquals(queue.size(), 0);

        queue.push(5);
        queue.push(11);

        //test push by seeing queue size
        expectEquals(queue.size(), 2);

        //test pop
        Integer testVal = queue.pop();
        Integer expected = 5;

        //make sure the right item was popped
        expectEquals(testVal, expected);

        //make sure the item was removed from the queue
        expectEquals(queue.size(), 1);
    }
}
