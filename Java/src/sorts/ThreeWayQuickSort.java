package sorts;

/**
 * Created by Chris Keyser on 3/17/2016.
 * quicksort with a 3-way partition implementation
 */
public class ThreeWayQuickSort extends Sort {
    public ThreeWayQuickSort(int[] arr) {
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
        int[] pivots = partition(start, end);

        //sort subarrays before and after pivot range
        quicksort(start, pivots[0]);
        quicksort(pivots[1] + 1, end);
    }

    /**
     * partition given arr around its left-most value
     * end index is exclusive
     */
    private int[] partition(int pivot, int end) {
        if(pivot == arr.length - 1) {
            int[] pivots = {pivot, pivot};
            return pivots;
        }

        int frontPivot = pivot, backPivot = pivot;

        for(int i = frontPivot; i < end; i++) {
            //if arr[i] < pivot value, move it in front of the pivot
            if(arr[i] < arr[frontPivot]) {
                swap(frontPivot, backPivot + 1);
                frontPivot++;
                backPivot++;
                swap(i, frontPivot - 1);
            } else if(arr[i] == arr[frontPivot]) {
                swap(i, backPivot + 1);
                backPivot++;
            }
        }

        //this declaration is here so i can use array initializer shorthand
        int[] pivots = {frontPivot, backPivot};

        return pivots;
    }
}
