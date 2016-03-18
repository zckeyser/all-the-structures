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
        quicksort(0, arr.length);
        return arr;
    }

    /**
     * method to recurse quicksort until arrays are split into sorted subarrays
     */
    private void quicksort(int start, int end) {
        if (start == end) {
            return;
        }

        //find pivot using partition()
        int pivot = partition(start, end);

        //sort subarrays before and after pivot
        quicksort(start, pivot);
        quicksort(pivot + 1, end);
    }

    /**
     * partition given arr around its left-most value
     * end index is exclusive
     */
    private int partition(int pivot, int end) {
        for(int i = pivot; i < end; i++) {
            //if arr[i] < pivot value, move it in front of the pivot
            if(arr[i] < arr[pivot]) {
                swap(pivot, pivot + 1);
                pivot++;
                swap(i, pivot - 1);
            }
        }

        return pivot;
    }
}
