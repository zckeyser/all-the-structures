package searches.informed;

import searches.informed.blocks.Board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Chris Keyser on 3/24/2016.
 * Best-first informed search implementation
 */
public class BestFirst {
    private Board root;

    public BestFirst(String filename) {
        root = new Board(filename);
    }

    public Board search() {
        Board curr = root;
        List<Board> toVisit = new ArrayList<>();

        //list of hashes of boards that have been visited
        HashMap<Integer, Boolean> visited = new HashMap<>();

        while(!(curr.goalState() || toVisit.isEmpty())) {
            //add current node to visited list
            visited.put(curr.hash(), true);

            //expand current node
            for(Board neighbor : curr.getNeighborBoardStates()) {
                if(!visited.containsKey(neighbor.hash())) {
                    toVisit.add(neighbor);
                }
            }

            //find node with best heuristic to expand next
            int minH = Integer.MAX_VALUE;
            Board minHBoard = curr;

            for(Board state : toVisit) {
                int currH = state.h();

                if(currH < minH) {
                    minH = currH;
                    minHBoard = state;
                }
            }

            curr = minHBoard;
            toVisit.remove(minHBoard);
        }

        return curr.goalState() ? curr : null;
    }
}
