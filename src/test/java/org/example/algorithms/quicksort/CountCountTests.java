package org.example.algorithms.quicksort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountCountTests {

    @Test
    void recursiveCount() {
        int[] array = {1, 2, 3};
        int result = RecursiveCount.recursiveCount(array);
        assertEquals(3, result);
    }

    @Test
    void recursiveCountEmptyArray() {
        int[] array = {};
        int result = RecursiveCount.recursiveCount(array);
        assertEquals(0, result);
    }
}
