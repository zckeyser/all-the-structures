package sorts;

import heaps.Heap;
import test.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Chris Keyser on 3/17/2016.
 * OthelloTest for all of the sorting algorithms
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
                new BubbleSort(copyOf(arr)),
                new InsertionSort(copyOf(arr)),
                new SelectionSort(copyOf(arr)),
                new RadixSort(copyOf(arr)),
                new QuickSort(copyOf(arr)),
                new MergeSort(copyOf(arr))
        };

        for(Sort sort : sorts) {
            System.out.print(sort.getClass().getSimpleName() + ": ");
            long startTime = System.nanoTime();

            expect("to be sorted", isSorted(sort.sort()));

            if(timed) {
                long endTime = System.nanoTime();

                double duration = (double) (endTime - startTime) / 1000000;  //divide by 1000000 to get milliseconds.

                System.out.print(" " + duration + "ms");
            }

            System.out.println();
        }

        //test heapsort because it's contained in Heap
//        Heap heap = new Heap();
//        System.out.print("HeapSort: ");
//
//        long startTime = System.nanoTime();
//
//        heap.heapSort(arr);
//        expect("to be sorted", isSorted(heap.getData()));
//
//        if(timed) {
//            long endTime = System.nanoTime();
//
//            double duration = (double) (endTime - startTime) / 1000000;  //divide by 1000000 to get milliseconds.
//
//            System.out.print(" " + duration + "ms");
//        }
    }

    /**
     * generates an array of random numbers of n length
     * currently generates numbers >= 0 because of radix sort
     */
    private int[] generateRandomArray(int n) {
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Math.abs(rng.nextInt());
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

    private int[] copyOf(int[] arr) {
        int[] newArr = new int[arr.length];

        for(int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }

        return newArr;
    }
}
