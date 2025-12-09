package com.example.algorithms.search;

import java.util.Arrays;

public class BinarySearch {

    private static final int NOT_FOUND = -1;

    public static int binarySearch(int[] list, int pickedNumber) {
        if (isEmpty(list)) {
            return NOT_FOUND;
        }
        Arrays.sort(list);

        int lowIndex = 0;
        int highIndex = list.length - 1;

        while (lowIndex <= highIndex) {
            int guessIndex = (lowIndex + highIndex) / 2;
            int midNumber = list[guessIndex];

            if (midNumber < pickedNumber) {
                lowIndex = guessIndex + 1;
            } else if (midNumber > pickedNumber) {
                highIndex = guessIndex - 1;
            } else {
                return midNumber;
            }
            sleep();
        }

        return NOT_FOUND;
    }

    private static boolean isEmpty(int[] list) {
        return list.length == 0;
    }

    private static void sleep() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
