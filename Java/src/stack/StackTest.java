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
        expect("Stack to be empty on initialization", stack.isEmpty());
        expectEquals("Stack to have size 0 on initialization", stack.size(), 0);

        stack.push(5);
        stack.push(11);

        //test push by seeing stack size
        expectEquals("Stack to have correct size after adding two elements", stack.size(), 2);

        //test pop
        Integer testVal = stack.pop();
        Integer expected = 11;

        //make sure the right item was popped
        expectEquals("The right element to be pulled from the stack", testVal, expected);

        //make sure the item was removed from the stack
        expectEquals("The size of the stack to decrease by 1 after pop", stack.size(), 1);
    }
}
