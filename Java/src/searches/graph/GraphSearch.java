package searches.uninformed;

import graphs.DirectedGraphNode;

/**
 * Created by Chris Keyser on 3/18/2016.
 * interface which graph searches implement
 */
public interface GraphSearch {
    boolean contains(int target, DirectedGraphNode root, boolean trace);
    String traverse(DirectedGraphNode root);
}
