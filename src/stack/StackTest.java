package stack;

import test.Test;

/**
 * Created by Chris Keyser on 3/17/2016.
 * Testing for Stack class
 */
public class StackTest extends Test {
    @Override
    public void run() {
        Stack<Integer> stack = new Stack<>();

        //test isEmpty and size with no data on stack
        expect(stack.isEmpty());
        expectEquals(stack.size(), 0);

        stack.push(5);
        stack.push(11);

        //test push by seeing stack size
        expectEquals(stack.size(), 2);

        //test pop
        Integer testVal = stack.pop();
        Integer expected = 11;

        //make sure the right item was popped
        expectEquals(testVal, expected);

        //make sure the item was removed from the stack
        expectEquals(stack.size(), 1);
    }
}
