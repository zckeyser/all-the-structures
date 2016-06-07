package searches.informed.blocks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Chris Keyser on 3/24/2016.
 * Class to handle board state/logic for sliding blocks game
 */
public class Board {
    private static final int GOAL = -1;
    private static final int EMPTY = 0;
    private static final int WALL = 1;
    private static int MASTER = 2;

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
    private boolean isValidMove(Move move) {
        XYOffset offset = move.getXYOffset();

        for(int i = 0; i < state.length; i++) {
            for(int j = 0; j < state[i].length; j++) {
                if(state[i][j] == move.getPiece()) {
                    int newX = i + offset.getX();
                    int newY = j + offset.getY();

                    //if it's off the board it's invalid
                    if(newX > state.length || newY > state[i].length) {
                        return false;
                    }

                    int neighborVal = state[newX][newY];

                    //can only move in this direction if onto a master/empty/same space
                    if(!(neighborVal == -1 || neighborVal == 0 || neighborVal == getMaxPiece())) {
                        return false;
                    }
                }
            }
        }


        return true;
    }

    // gets all valid moves from current board state
    private List<Move> getValidMoves() {
        List<Move> validMoves = new ArrayList<>();

        for(int i = MASTER; i < getMaxPiece(); i++) {
            for(int direction : Move.DIRECTIONS) {
                Move currMove = new Move(i, direction);

                if(isValidMove(currMove)) {
                    validMoves.add(currMove);
                }
            }
        }

        return validMoves;
    }

    private int getMaxPiece() {
        int max = -1;

        for(int[] row : state) {
            for(int val : row) {
                if(max < val) {
                    max = val;
                }
            }
        }

        return max;
    }

    // gets all states which are a result of a move from getValidMoves()
    public List<Board> getNeighborBoardStates() {
        return getValidMoves()
                .stream()
                .map(move -> applyMoveCloning(move))
                .collect(Collectors.toCollection(ArrayList::new));
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

    // function returning # of moves to reach this state
    public int numMoves() {
        return moves.size();
    }
}
