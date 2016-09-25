import searches.array.ArraySearchTest;
import searches.graph.UninformedSearchTest;
import sorts.SortTest;
import stack.QueueTest;
import stack.StackTest;
import test.Suite;
import trees.BinarySearchTreeTest;

/**
 * Created by Chris Keyser on 3/17/2016.
 * Driver class
 * set various flags to choose whether or not to run tests for various types
 */
public class Main {
    private static boolean BINARY_SEARCH_TREE = true;
    private static boolean STACK = true;
    private static boolean QUEUE = true;
    private static boolean ARRAY_SEARCH = true;
    private static boolean SORT = true;
    private static boolean SORT_TIMING = true;
    private static boolean UNGUIDED_SEARCH = true;

    //TODO less naive way of deciding what tests to run?
    public static void main(String[] args) {
        Suite suite = new Suite();

        if(BINARY_SEARCH_TREE) suite.addTest(new BinarySearchTreeTest());
        if(STACK) suite.addTest(new StackTest());
        if(QUEUE) suite.addTest(new QueueTest());
        if(ARRAY_SEARCH) suite.addTest(new ArraySearchTest());
        if(SORT) suite.addTest(new SortTest(SORT_TIMING));
        if(UNGUIDED_SEARCH) suite.addTest(new UninformedSearchTest());

        suite.run();
    }
}
