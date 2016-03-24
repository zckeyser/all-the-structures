package searches.informed.blocks;

/**
 * Created by Chris Keyser on 3/24/2016.
 * class to represent an x/y offset in a grid
 */
public class XYOffset {
    private int x, y;

    public XYOffset(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
