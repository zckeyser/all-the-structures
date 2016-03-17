package sorts;

/**
 * Created by Chris Keyser on 3/17/2016.
 * Bubble sort implementation
 */
public class BubbleSort extends Sort {
    public BubbleSort(int[] arr) {
        this.arr = arr;
    }

    @Override
    public int[] sort() {
        boolean swapped = true;

        while(swapped) {
            swapped = false;

            for(int i = 0; i < arr.length - 1; i++) {
                if(arr[i] > arr[i + 1]) {
                    swap(i, i + 1);
                    swapped = true;
                }
            }
        }

        return arr;
    }
}
