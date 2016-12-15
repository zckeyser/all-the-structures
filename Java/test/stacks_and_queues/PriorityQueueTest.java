package stacks_and_queues;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Chris Keyser on 10/3/2016.
 */
public class PriorityQueueTest {
    private PriorityQueue<Integer> queue;

    @Before
    public void setUp() {
        queue = new PriorityQueue<>(5);
    }

    @Test
    public void PriorityQueue_Initialization() {
        Assert.assertTrue("priority queue begins empty", queue.isEmpty());
        Assert.assertEquals("priority queue begins with size 0", 0, queue.size());
        Assert.assertEquals("priority queue has correct level count", 5, queue.levels());
    }

    @Test
    public void PriorityQueue_SingleLevelEnqueueDequeue() {
        queue.enqueue(10, 0);
        queue.enqueue(20, 0);
        queue.enqueue(30, 0);

        Integer result[] = new Integer[3];
        Integer expected[] = {10, 20, 30};

        for(int i = 0; i < result.length; i++) { result[i] = queue.dequeue(); }

        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void PriorityQueue_MultiLevelEnqueueDequeue() {
        queue.enqueue(10, 0);
        queue.enqueue(20, 0);
        queue.enqueue(30, 1);
        queue.enqueue(40, 1);
        queue.enqueue(50, 3);
        queue.enqueue(60, 3);
        queue.enqueue(70, 3);
        queue.enqueue(80, 2);
        queue.enqueue(90, 4);
        queue.enqueue(100, 4);

        Integer result[] = new Integer[10];
        Integer expected[] = {90, 100, 50, 60, 70, 80, 30, 40, 10, 20};

        for(int i = 0; i < result.length; i++) { result[i] = queue.dequeue(); }

        Assert.assertArrayEquals(expected, result);
    }
}
