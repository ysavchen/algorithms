package org.example.data.structures.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void getElement() {
        var array = new UnsortedArray<String>(1);
        var element = "Anna";
        array.addElement(element);
        assertEquals(element, array.getElement(0));
    }

    @Test
    void getNullElement() {
        var array = new UnsortedArray<String>(1);
        assertNull(array.getElement(0));
    }

    @Test
    void getElementByNegativeIndex() {
        var array = new UnsortedArray<String>(1);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> array.getElement(-1));
    }

    @Test
    void getElementOutOfBounds() {
        var array = new UnsortedArray<String>(1);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> array.getElement(1));
    }

    @Test
    void findElement() {
        var array = new UnsortedArray<String>(1);
        array.addElement("Anna");
        assertEquals(0, array.findElement("Anna"));
    }

    @Test
    void findNullElement() {
        var array = new UnsortedArray<String>(2);
        array.addElement("Anna");
        assertEquals(1, array.findElement(null));
    }

    @Test
    void findNonExistingElement() {
        var array = new UnsortedArray<String>(1);
        assertEquals(-1, array.findElement("Anna"));
    }
}
