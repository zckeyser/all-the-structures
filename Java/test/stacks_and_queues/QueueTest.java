package stacks_and_queues;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Chris Keyser on 10/3/2016.
 */
public class QueueTest {
    private Queue<Integer> queue;

    @Before
    public void setUp() {
        queue = new Queue<>();
    }

    @Test
    public void Queue_Initialization() {
        Assert.assertTrue("Queue to be empty on initialization", queue.isEmpty());
        Assert.assertEquals("Queue to have size 0 on initialization", 0, queue.size());
    }

    @Test
    public void Queue_AfterEnqueue_HasCorrectSize() {
        queue.enqueue(5);
        queue.enqueue(11);

        Assert.assertEquals("Queue to have correct size after adding two elements", 2, queue.size());
    }

    @Test
    public void Queue_Dequeue_GetsCorrectValues() {
        queue.enqueue(5);
        queue.enqueue(11);

        Integer testVal = queue.dequeue();
        Integer expected = 5;

        Assert.assertEquals("The right element to be pulled from the queue", expected, testVal);

        testVal = queue.dequeue();
        expected = 11;

        Assert.assertEquals("The right element to be pulled from the queue", expected, testVal);
    }

    @Test
    public void Queue_Dequeue_ChangesSizeCorrectly() {
        queue.enqueue(5);
        queue.enqueue(11);
        queue.dequeue();
        queue.dequeue();

        Assert.assertEquals("The size of Queue to decrease by 1 after dequeue", 1, queue.size());
        Assert.assertEquals("The size of Queue to decrease by 1 after dequeue", 0, queue.size());
        Assert.assertTrue("The queue to be empty after all items are dequeued", queue.isEmpty());
    }
}
