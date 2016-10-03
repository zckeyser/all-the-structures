package searches;

/**
 * Created by Chris Keyser on 10/3/2016.
 */
public class LinearSearch {
    /**
     * linear search implementation
     * works on any array but is slow
     * O(n) efficiency
     */
    public static boolean contains(int[] arr, int n) {
        for(int m : arr)
            if(m == n)
                return true;

        return false;
    }
}
