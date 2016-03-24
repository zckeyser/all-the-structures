package searches.informed.blocks;

/**
 * Created by Chris Keyser on 3/24/2016.
 * Models a move in the sliding blocks game
 */
public class Move {
    public static final int RIGHT = 0;
    public static final int DOWN = 1;
    public static final int LEFT = 2;
    public static final int UP = 3;

    private int piece;
    private int direction;

    public Move(int piece, int direction) {
        this.piece = piece;
        this.direction = direction;
    }

    public int getPiece() {
        return piece;
    }

    public void setPiece(int piece) {
        this.piece = piece;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    /**
     * gets the x/y offset of a move relative to the 2d matrix representing the board
     */
    public XYOffset getXYOffset(int direction) {
        switch(direction) {
            case RIGHT:
                return new XYOffset(1, 0);
            case DOWN:
                return new XYOffset(0, 1);
            case LEFT:
                return new XYOffset(-1, 0);
            case UP:
                return new XYOffset(0, -1);
            default:
                return null;
        }
    }

    public String getDirectionString(int direction) {
        switch(direction) {
            case RIGHT:
                return "Right";
            case DOWN:
                return "Down";
            case LEFT:
                return "Left";
            case UP:
                return "Up";
            default:
                return "Invalid Direction";
        }
    }
}
