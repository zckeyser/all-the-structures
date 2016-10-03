package util;

import java.util.Random;

/**
 * Created by Chris Keyser on 10/3/2016.
 */
public class TestUtil {
    public static final int ARR_SIZE = 1000;

    private static Random rand = new Random();

    /**
     * generates an array of random numbers of n length
     * currently generates numbers >= 0 because of radix sort
     */
    public static int[] generateRandomArray(int len) {
        int[] arr = new int[len];

        for(int i = 0; i < len; i++) {
            arr[i] = Math.abs(rand.nextInt());
        }

        return arr;
    }
}
