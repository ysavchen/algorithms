package org.example.algorithms.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RecursiveMaxTests {

    @Test
    void recursiveMax() {
        int[] array = {1, 4, 3, 2};
        int result = RecursiveMax.recursiveMax(array);
        assertEquals(4, result);
    }

    @Test
    void recursiveMaxEmptyArray() {
        int[] array = {};
        assertThrows(IllegalArgumentException.class, () -> RecursiveMax.recursiveMax(array));
    }
}
