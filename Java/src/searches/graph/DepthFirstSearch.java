package searches.graph;

import graphs.DirectedGraphNode;
import stack.Stack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris Keyser on 3/18/2016.
 * DFS implementation for a Directed Graph (note: not just DAGs, though it will also work on a DAG)
 */
public class DepthFirstSearch implements GraphSearch {
    /**
     * determines if graph starting at root contains target using DFS
     * @param trace if true, trace of search is printed to stdout
     */
    @Override
    public boolean contains(int target, DirectedGraphNode root, boolean trace) {
        //see if root contains target
        if(root.getVal() == target) {
            return true;
        }

        if(trace) {
            System.out.print(root.getVal() + " ");
        }

        Stack<DirectedGraphNode> stack = new Stack<>(root.getNeighbors());
        List<DirectedGraphNode> visited = new ArrayList<>();

        while(!stack.isEmpty()) {
            //same as BFS but uses a stack
            DirectedGraphNode next = stack.pop();
            visited.add(next);

            if(trace) {
                System.out.print(next.getVal() + " ");
            }


            if(next.getVal() == target) {
                return true;
            }

            //add unvisited neighbors
            for(DirectedGraphNode node : next.getNeighbors()) {
                if(!(visited.contains(node) || stack.contains(node))) {
                    stack.push(node);
                }
            }
        }

        return false;
    }

    /**
     * returns a string representing the DFS traversal of a graph from root
     */
    @Override
    public String traverse(DirectedGraphNode root) {
        String output = root.getVal() + " ";

        Stack<DirectedGraphNode> stack = new Stack<>(root.getNeighbors());
        List<DirectedGraphNode> visited = new ArrayList<>();

        while(!stack.isEmpty()) {
            DirectedGraphNode next = stack.pop();
            visited.add(next);

            output += next.getVal() + " ";

            //add unvisited neighbors
            for(DirectedGraphNode node : next.getNeighbors()) {
                if(!(visited.contains(node) || stack.contains(node))) {
                    stack.push(node);
                }
            }
        }

        return output.trim();
    }
}