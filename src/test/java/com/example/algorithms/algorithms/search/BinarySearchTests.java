package com.example.algorithms.algorithms.search;

import com.example.algorithms.search.BinarySearch;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

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

    @Test
    void searchNonSortedList() {
        int[] list = {14, 5, 9, 2};
        int pickedNumber = 9;
        int searchResult = BinarySearch.binarySearch(list, pickedNumber);
        assertEquals(pickedNumber, searchResult);
    }

    @Test
    void searchTime() {
        int[] list = IntStream.iterate(1, i -> i + 1)
                .limit(100L)
                .toArray();
        int pickedNumber = 100;
        long startMillis = System.currentTimeMillis();
        BinarySearch.binarySearch(list, pickedNumber);
        long endMillis = System.currentTimeMillis();
        System.out.println("Binary search: " + (endMillis - startMillis) + "ms");
    }

    @Test
    void searchEmptyList() {
        int[] list = {};
        int pickedNumber = 10;
        int searchResult = BinarySearch.binarySearch(list, pickedNumber);
        assertEquals(NOT_FOUND, searchResult);
    }
}
