package searches.uninformed;

import graphs.DirectedGraphNode;
import stack.Queue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris Keyser on 3/18/2016.
 * BFS implementation for a Directed Graph (note: not just DAGs, though it will also work on a DAG)
 */
public class BreadthFirstSearch implements GraphSearch {
    /**
     * determines if graph starting at root contains target using BFS
     * @param trace if true, trace of search is printed to stdout
     */
    @Override
    public boolean contains(int target, DirectedGraphNode root, boolean trace) {
        //see if root contains target
        if(root.getVal() == target) {
            return true;
        }

        //print trace if necessary
        if(trace) {
            System.out.print(root.getVal() + " ");
        }

        //initialize queue to root's neighbors
        Queue<DirectedGraphNode> queue = new Queue<>(root.getNeighbors());
        List<DirectedGraphNode> visited = new ArrayList<>();

        //while there's still nodes to check keep looking
        while(!queue.isEmpty()) {
            //get node from queue and add to visited
            DirectedGraphNode next = queue.pop();
            visited.add(next);

            //trace if necessary
            if(trace) {
                System.out.print(next.getVal() + " ");
            }

            //check to see if this node contains target
            if(next.getVal() == target) {
                return true;
            }

            //add unvisited neighbors
            for(DirectedGraphNode node : next.getNeighbors()) {
                if(!(visited.contains(node) || queue.contains(node))) {
                    queue.push(node);
                }
            }
        }

        return false;
    }

    /**
     * returns a string representing the BFS traversal of a graph from root
     */
    @Override
    public String traverse(DirectedGraphNode root) {
        String output = root.getVal() + " ";

        Queue<DirectedGraphNode> queue = new Queue<>(root.getNeighbors());
        List<DirectedGraphNode> visited = new ArrayList<>();

        while(!queue.isEmpty()) {
            DirectedGraphNode next = queue.pop();
            visited.add(next);

            output += next.getVal() + " ";

            //add unvisited neighbors
            for(DirectedGraphNode node : next.getNeighbors()) {
                if(!(visited.contains(node) || queue.contains(node))) {
                    queue.push(node);
                }
            }
        }

        return output.trim();
    }
}
