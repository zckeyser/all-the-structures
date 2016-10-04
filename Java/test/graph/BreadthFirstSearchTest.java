package graph;

import graphs.BreadthFirstSearch;
import graphs.DirectedGraphNode;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Chris Keyser on 10/3/2016.
 */
public class BreadthFirstSearchTest {
    private static DirectedGraphNode root;
    private static BreadthFirstSearch bfs;

    @BeforeClass
    public static void setUp() {
        root = GraphGenerator.makeGraph();
        bfs = new BreadthFirstSearch();
    }

    @Test
    public void BreadthFirstSearch_Contains_Positive() {
        Assert.assertTrue("BFS contains to find a value in the graph correctly", bfs.contains(63, root, false));
    }

    @Test
    public void BreadthFirstSearch_Contains_Negative() {
        Assert.assertTrue("BFS contains to not find a value that is not in the graph", !bfs.contains(60, root, false));
    }

    @Test
    public void BreadthFirstSearch_Traverse() {
        String expected = "21 14 18 39 51 63 16 27 84 11 30 33 36";

        Assert.assertEquals("BFS to traverse the graph correctly", bfs.traverse(root), expected);
    }
}
