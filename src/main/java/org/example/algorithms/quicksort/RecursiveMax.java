package org.example.algorithms.quicksort;

import java.util.Arrays;

public class RecursiveMax {

    public static int recursiveMax(int[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException();
        }
        if (array.length == 1) {
            return array[0];
        }
        int[] newArray = Arrays.copyOfRange(array, 1, array.length);
        return Math.max(array[0], recursiveMax(newArray));
    }
}
