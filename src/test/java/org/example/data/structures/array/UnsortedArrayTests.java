package org.example.data.structures.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnsortedArrayTests {

    @Test
    void createArray() {
        var array = new UnsortedArray<String>(5);
        assertEquals(5, array.getSize());
        assertEquals(0, array.getNumberOfElements());
    }

    @Test
    void addElement() {
        var array = new UnsortedArray<String>(1);
        array.addElement("Anna");
        assertEquals(1, array.getSize());
        assertEquals(1, array.getNumberOfElements());
    }

    @Test
    void removeElement() {
        var array = new UnsortedArray<String>(1);
        array.addElement("Anna");
        assertEquals(1, array.getSize());
        assertEquals(1, array.getNumberOfElements());

        array.removeElement(0);
        assertEquals(1, array.getSize());
        assertEquals(0, array.getNumberOfElements());
    }
}
