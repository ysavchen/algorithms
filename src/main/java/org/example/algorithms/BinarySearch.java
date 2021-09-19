package org.example.algorithms;

import java.util.Arrays;
import java.util.Optional;

public class BinarySearch {

    private static final int NOT_FOUND = -1;

    public static void main(String[] args) {
        int[] list = {9, 14, 2, 5};
        int existingPickedNumber = 9;
        int nonExistingPickedNumber = 22;
        int searchResult = binarySearch(list, nonExistingPickedNumber);
        System.out.println(searchResult);
    }

    private static int binarySearch(int[] list, int pickedNumber) {
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
        }

        return NOT_FOUND;
    }

    private static boolean isEmpty(int[] list) {
        return list.length == 0;
    }
}
