package sorts;

/**
 * Created by Chris Keyser on 3/17/2016.
 * Insertion sort implementation
 */
public class InsertionSort extends Sort {
    public InsertionSort(int[] arr) {
        this.arr = arr;
    }

    @Override
    public int[] sort() {
        for(int i = 0; i < arr.length; i++) {
            for(int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                swap(j, j - 1);
            }
        }

        return arr;
    }
}
