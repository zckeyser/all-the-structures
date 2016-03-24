package sorts;

/**
 * Created by Chris Keyser on 3/17/2016.
 * 2-way partition quicksort implementation
 */
public class QuickSort extends Sort {
    public QuickSort(int[] arr) {
        this.arr = arr;
    }

    @Override
    public int[] sort() {
        quicksort(0, arr.length - 1);
        return arr;
    }

    private void quicksort(int lowerIndex, int higherIndex) {

        int i = lowerIndex;
        int j = higherIndex;
        // take middle number for pivot
        int pivot = arr[lowerIndex + (higherIndex - lowerIndex) / 2];
        // Divide into two arrays
        while (i <= j) {
            //find a number from the left side less than pivot
            while (arr[i] < pivot) {
                i++;
            }

            //find a number from the right side greater than pivot
            while (arr[j] > pivot) {
                j--;
            }

            //swap them
            if (i <= j) {
                swap(i, j);

                i++;
                j--;
            }
        }

        // call quickSort() method recursively
        if (lowerIndex < j)
            quicksort(lowerIndex, j);
        if (i < higherIndex)
            quicksort(i, higherIndex);
    }
}
