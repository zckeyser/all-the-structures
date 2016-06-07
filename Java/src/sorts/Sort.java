package sorts;

/**
 * Created by Chris Keyser on 3/17/2016.
 * interface representing a class that implements a sorting method
 */
public abstract class Sort {
    protected int[] arr;

    public abstract int[] sort();

    protected void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
