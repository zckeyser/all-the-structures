package heaps;

/**
 * Created by Chris Keyser on 3/17/2016.
 * Heap implementation using an array representation
 * a heap is a special type of tree where every node has children with greater value than their parent
 * for a node at index k, the following statements hold true:
 * left child is at 2*k
 * right child is at 2*k + 1
 * parent is at k/2
 *
 * as a result 0 is always empty
 */
public class Heap {
    private static final int DEFAULT_INIT_SIZE = 2;

    private int[] data;
    private int size;

    public Heap() {
        data = new int[DEFAULT_INIT_SIZE];
        size = 0;
    }

    /**
     * builds a heap from given int array
     */
    public Heap(int[] arr) {
        size = arr.length;
        this.data = new int[arr.length + 1];

        System.arraycopy(arr, 0, data, 1, arr.length); //we do not use 0 index

        buildHeap();
    }

    //for testing
    public int[] getData() {
        return data;
    }

    /**
     * runs at O(n)
     * builds a heap from existing data
     */
    private void buildHeap()
    {
        for (int k = size/2; k > 0; k--)
        {
            percolateDown(k);
        }
    }

    /**
     * percolates down the tree to percolateDown
     */
    private void percolateDown(int k) {
        int tmp = data[k];
        int child;

        for(; 2 * k <= size; k = child) {
            //grab left child index
            child = 2 * k;

            //if the left child is in the heap and it's larger than its parent check the right child
            if(child != size && data[child] > data[child + 1]) {
                child++;
            }

            //if the parent is larger than the right child then swap them
            if(tmp > data[child]){
                data[k] = data[child];
            } else {
                break;
            }

        }

        data[k] = tmp;
    }

    /**
     * Inserts a new item into the heap
     */
    public void insert(int n) {
        //if the heap is going to grow beyond the size of the array grow the array to accommodate it
        if(size == data.length - 1) {
            doubleSize();
        }

        //Insert a new item to the end of the array and increment size to reflect it being added
        size++;
        int pos = size;

        //Percolate up to maintain heap by moving n up to an index where it's no longer less than its parent
        for(; pos > 1 && n < data[pos/2]; pos = pos/2 ) {
            data[pos] = data[pos/2];
        }

        //once n is moved far enough up to satisfy the heap rule set it at that position
        data[pos] = n;
    }

    /**
     * double the size of the data array to allow more numbers to be added
     */
    private void doubleSize() {
        int[] old = data;
        data = new int[data.length * 2];
        System.arraycopy(old, 1, data, 1, size);
    }

    /**
     * sorts a given array of items
     * warning: this replaces the current data set in the heap
     */
    public void heapSort(int[] array) {
        size = array.length;
        data = new int[size + 1];
        System.arraycopy(array, 0, data, 1, size);
        buildHeap();

        /**
         * this functions by repeatedly taking the root of the heap (the smallest number) at index 1
         * then reforming the heap not including that number, until eventually the entire heap has been turned
         * into a sorted array
         */
        for(int i = size; i > 0; i--) {
            int tmp = data[i]; //move top item to the end of the heap array
            data[i] = data[1];
            data[1] = tmp;
            size--;
            percolateDown(1);
        }

        /**
         * reverse number so that small numbers are in front
         * w/o this sort would be descending
         */
        for(int k = 0; k < data.length - 1; k++) {
            array[k] = data[data.length - 1 - k];
        }
    }
}
