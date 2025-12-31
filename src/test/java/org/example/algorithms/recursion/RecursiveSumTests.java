package org.example.algorithms.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecursiveSumTests {

    @Test
    void cyclicSum() {
        int[] array = {1, 2, 3};
        int result = RecursiveSum.cyclicSum(array);
        assertEquals(6, result);
    }

    @Test
    void cyclicSumEmptyArray() {
        int[] array = {};
        int result = RecursiveSum.cyclicSum(array);
        assertEquals(0, result);
    }

    @Test
    void recursiveSum() {
        int[] array = {1, 2, 3};
        int result = RecursiveSum.recursiveSum(array);
        assertEquals(6, result);
    }

    @Test
    void recursiveSumEmptyArray() {
        int[] array = {};
        int result = RecursiveSum.recursiveSum(array);
        assertEquals(0, result);
    }
}
