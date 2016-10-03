package graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris Keyser on 3/18/2016.
 * represents a node in a directed graph
 */
public class DirectedGraphNode {
    private List<DirectedGraphNode> neighbors;
    private int val;

    public DirectedGraphNode(int val) {
        this.val = val;
        this.neighbors = new ArrayList<>();
    }

    public DirectedGraphNode(int val, List<DirectedGraphNode> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
    
    public boolean hasNeighbor(DirectedGraphNode neighbor) {
        return neighbors.contains(neighbor);
    }

    public void addNeighbor(DirectedGraphNode neighbor) {
        neighbors.add(neighbor);
    }

    public void removeNeighbor(DirectedGraphNode neighbor) {
        neighbors.remove(neighbor);
    }

    public List<DirectedGraphNode> getNeighbors() {
        return new ArrayList<>(neighbors);
    }

    public int getVal() {
        return val;
    }
}
