package sorts;

import java.util.Random;

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
        shuffle();
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

    //standard shuffling algorithm
    //used to avoid bad case for qsort of almost-sorted array
    private void shuffle() {
        Random rand = new Random();

        for(int i = 0; i < arr.length; i++) {
            swap(i, rand.nextInt(arr.length));
        }
    }
}
