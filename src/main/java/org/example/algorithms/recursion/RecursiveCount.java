package org.example.algorithms.recursion;

import java.util.Arrays;

public class RecursiveCount {

    public static int recursiveCount(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return 1;
        }
        int[] newArray = Arrays.copyOfRange(array, 1, array.length);
        return 1 + recursiveCount(newArray);
    }
}
