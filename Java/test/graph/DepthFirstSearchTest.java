package graph;

import graphs.DepthFirstSearch;
import graphs.DirectedGraphNode;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Chris Keyser on 10/3/2016.
 */
public class DepthFirstSearchTest {
    private static DirectedGraphNode root;
    private static DepthFirstSearch dfs;

    @BeforeClass
    public static void setUp() {
        root = GraphGenerator.makeGraph();
        dfs = new DepthFirstSearch();
    }

    @Test
    public void BreadthFirstSearch_Contains_Positive() {
        Assert.assertTrue("DFS contains to find a value in the graph correctly", dfs.contains(63, root, false));
    }

    @Test
    public void BreadthFirstSearch_Contains_Negative() {
        Assert.assertFalse("DFS contains to not find a value that is not in the graph", dfs.contains(60, root, false));
    }

    @Test
    public void BreadthFirstSearch_Traverse() {
        String expected = "21 39 27 30 33 36 16 11 84 18 63 14 51";

        Assert.assertEquals("DFS to traverse the graph correctly", dfs.traverse(root), expected);
    }
}
