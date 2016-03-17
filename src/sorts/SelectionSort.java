package sorts;

/**
 * Created by Chris Keyser on 3/17/2016.
 * Selection sort implementation
 */
public class SelectionSort extends Sort {
    public SelectionSort(int[] arr) {
        this.arr = arr;
    }

    @Override
    public int[] sort() {
        for(int i = 0; i < arr.length; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;

            for(int j = i; j < arr.length; j++) {
                if(arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }

            swap(i, minIndex);
        }

        return arr;
    }
}
