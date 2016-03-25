package searches.informed;

import searches.informed.blocks.Board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Chris Keyser on 3/24/2016.
 * A* algorithm implementation
 */
public class AStar {
    private Board root;

    public AStar(String filename) {
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
            int minHC = Integer.MAX_VALUE;
            Board minHCBoard = curr;

            for(Board state : toVisit) {
                int currH = state.h() + state.cost();

                if(currH < minHC) {
                    minHC = currH;
                    minHCBoard = state;
                }
            }

            curr = minHCBoard;
            toVisit.remove(minHCBoard);
        }

        return curr.goalState() ? curr : null;
    }
}
