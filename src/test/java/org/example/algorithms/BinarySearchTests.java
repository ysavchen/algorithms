package org.example.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTests {

    private static final int NOT_FOUND = -1;

    @Test
    void searchExistingNumber() {
        int[] list = {9, 14, 2, 5};
        int existingPickedNumber = 9;
        int searchResult = BinarySearch.binarySearch(list, existingPickedNumber);
        assertEquals(existingPickedNumber, searchResult);
    }

    @Test
    void searchNonExistingNumber() {
        int[] list = {9, 14, 2, 5};
        int nonExistingPickedNumber = 22;
        int searchResult = BinarySearch.binarySearch(list, nonExistingPickedNumber);
        assertEquals(NOT_FOUND, searchResult);
    }
}
