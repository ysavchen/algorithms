package org.example.data.structures.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SortedArrayTests {

    @Test
    void createArray() {
        var array = new SortedArray<String>(5);
        assertEquals(5, array.getSize());
        assertEquals(0, array.getNumberOfElements());
    }

    @Test
    void createArrayWithNegativeSize() {
        assertThrows(IllegalArgumentException.class, () -> new SortedArray<String>(-1));
    }
}
