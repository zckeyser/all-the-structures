package stacks_and_queues;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Chris Keyser on 10/3/2016.
 */
public class StackTest {
    private Stack<Integer> stack;

    @Before
    public void setUp() {
        stack = new Stack<>();
    }

    @Test
    public void Stack_Initialization() {
        //test isEmpty and size with no data on stack
        Assert.assertTrue("Stack to be empty on initialization", stack.isEmpty());
        Assert.assertEquals("Stack to have size 0 on initialization", stack.size(), 0);

        stack.push(5);
        stack.push(11);

        //test enqueue by seeing stack size
        Assert.assertEquals("Stack to have correct size after adding two elements", stack.size(), 2);

        //test dequeue
        Integer testVal = stack.pop();
        Integer expected = 11;

        //make sure the right item was popped
        Assert.assertEquals("The right element to be pulled from the stack", testVal, expected);

        //make sure the item was removed from the stack
        Assert.assertEquals("The size of the stack to decrease by 1 after dequeue", stack.size(), 1);
    }
}
