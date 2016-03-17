import test.Suite;
import trees.BinarySearchTreeTest;

/**
 * Created by Chris Keyser on 3/17/2016.
 * Driver class
 * set various flags to choose whether or not to run tests for various types
 */
public class Main {
    static boolean BINARY_SEARCH_TREE = true;

    public static void main(String[] args) {
        Suite suite = new Suite();

        if(BINARY_SEARCH_TREE) {
            suite.addTest(new BinarySearchTreeTest());
        }

        suite.run();
    }
}
