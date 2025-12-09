package com.example.algorithms.search;

public class LinearSearch {

    private static final int NOT_FOUND = -1;

    public static int linearSearch(int[] list, int pickedNumber) {
        if (isEmpty(list)) {
            return NOT_FOUND;
        }

        for (int guessNumber : list) {
            if (guessNumber == pickedNumber) {
                return guessNumber;
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
