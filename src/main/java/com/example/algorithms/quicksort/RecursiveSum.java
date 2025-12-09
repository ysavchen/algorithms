package com.example.algorithms.quicksort;

import java.util.Arrays;

public class RecursiveSum {

    public static int cyclicSum(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int total = 0;
        for (int x : array) {
            total += x;
        }
        return total;
    }

    public static int recursiveSum(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        int[] newArray = Arrays.copyOfRange(array, 1, array.length);
        return array[0] + recursiveSum(newArray);
    }
}
