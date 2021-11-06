package org.example.algorithms.search;

import org.example.algorithms.search.LinearSearch;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinearSearchTests {

    private static final int NOT_FOUND = -1;

    @Test
    void searchExistingNumber() {
        int[] list = {9, 14, 2, 5};
        int existingPickedNumber = 9;
        int searchResult = LinearSearch.linearSearch(list, existingPickedNumber);
        assertEquals(existingPickedNumber, searchResult);
    }

    @Test
    void searchNonExistingNumber() {
        int[] list = {9, 14, 2, 5};
        int nonExistingPickedNumber = 22;
        int searchResult = LinearSearch.linearSearch(list, nonExistingPickedNumber);
        assertEquals(NOT_FOUND, searchResult);
    }

    @Test
    void searchTime() {
        int[] list = IntStream.iterate(1, i -> i + 1)
                .limit(100L)
                .toArray();
        int pickedNumber = 100;
        long startMillis = System.currentTimeMillis();
        LinearSearch.linearSearch(list, pickedNumber);
        long endMillis = System.currentTimeMillis();
        System.out.println("Linear search: " + (endMillis - startMillis) + "ms");
    }

    @Test
    void searchEmptyList() {
        int[] list = {};
        int pickedNumber = 10;
        int searchResult = LinearSearch.linearSearch(list, pickedNumber);
        assertEquals(NOT_FOUND, searchResult);
    }
}
