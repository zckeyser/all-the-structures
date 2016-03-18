package sorts;

import test.Test;

import java.util.Random;

/**
 * Created by Chris Keyser on 3/17/2016.
 * Test for all of the sorting algorithms
 * will do timing to show the differing efficiency
 */
public class SortTest extends Test {
    private Random rng;
    private boolean timed;
    //WARNING: quicksort gets a StackOverflowError with larger array sizes
    private static final int ARR_SIZE = 10000;

    public SortTest() {
        rng = new Random();
    }

    public SortTest(boolean timed) {
        rng = new Random();
        this.timed = timed;
    }

    @Override
    public void run() {
        int[] arr = generateRandomArray(ARR_SIZE);

        Sort[] sorts = {
                new BubbleSort(arr),
                new InsertionSort(arr),
                new SelectionSort(arr),
                new RadixSort(arr),
                new QuickSort(arr),
                new MergeSort(arr)
        };

        for(Sort sort : sorts) {
            long startTime = 0;
            if(timed) {
                startTime = System.nanoTime();
            }

            System.out.print(sort.getClass().getSimpleName() + ": ");

            expect(isSorted(sort.sort()));

            if(timed) {
                long endTime = System.nanoTime();

                double duration = (double) (endTime - startTime) / 1000000;  //divide by 1000000 to get milliseconds.

                System.out.print(" " + duration + "ms");
            }

            System.out.println();
        }
    }

    /**
     * generates an array of random numbers of n length
     */
    private int[] generateRandomArray(int n) {
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = rng.nextInt();
        }

        return arr;
    }

    /**
     * checks to see if an array is sorted
     */
    private boolean isSorted(int[] arr) {
        for(int i = 0; i < arr.length - 2; i++) {
            if(arr[i] > arr[i + 1]) {
                return false;
            }
        }

        return true;
    }
}
