package searches.informed.blocks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Chris Keyser on 3/24/2016.
 * Class to handle board state/logic for sliding blocks game
 */
public class Board {
    private static final int DEFAULT_SIZE = 10;
    private static final int GOAL = -1;
    private static final int EMPTY = 0;
    private static final int MASTER = 1;

    private int[][] state;

    // list of moves to reach this state
    private List<Move> moves;

    // constructor to load from file
    public Board(String templatePath) {
        loadFromFile(templatePath);
    }

    // copy constructor
    public Board(Board orig) {
        this.state = new int[orig.state.length][orig.state[0].length];

        for(int i = 0; i < orig.state.length; i++) {
            for(int j = 0; i < orig.state[j].length; j++) {
                this.state[i][j] = orig.state[i][j];
            }
        }

        Collections.copy(this.moves, orig.moves);
    }

    //loads board state from template file
    private void loadFromFile(String path) {

    }

    //produces an integer hash for current state
    public int hash() {
        int hashNum = 0;

        for(int i = 0; i < state.length; i++) {
            for(int j = 0; j < state[i].length; j++) {
                hashNum += state[i][j] * Math.pow(i, 2) * Math.pow(j, 3);
            }
        }

        return hashNum;
    }

    // checks if given move is valid for current board stater
    private boolean validMove(Move move) {
        return false;
    }

    // gets all valid moves from current board state
    private List<Move> getValidMoves() {
        return new ArrayList<>();
    }

    // gets all states which are a result of a move from getValidMoves()
    public List<Board> getNeighborBoardStates() {
        return new ArrayList<>();
    }

    //applies move to current board
    public void applyMove(Move move) {

    }

    public Board applyMoveCloning(Move move) {
        Board clone = new Board(this);
        clone.applyMove(move);
        return clone;
    }

    public boolean goalState() {
        //if the goal spaces are covered, the board is solved
        return !contains(-1);
    }

    public boolean contains(int piece) {
        for(int[] row : state) {
            for(int val : row) {
                if(val == piece) {
                    return false;
                }
            }
        }

        return true;
    }

    // heuristic function for current state
    public int h() {
        return 0;
    }

    // cost function for current state
    public int cost() {
        return moves.size();
    }
}
