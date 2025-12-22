package org.example.data.structures.array;

import org.example.data.structures.array.exception.EmptyArrayException;
import org.example.data.structures.array.exception.FullArrayException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UnsortedArrayTests {

    @Test
    void createArray() {
        var array = new UnsortedArray<String>(5);
        assertEquals(5, array.getSize());
        assertEquals(0, array.getNumberOfElements());
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
    void addElement() {
        var array = new UnsortedArray<String>(1);
        array.addElement("Anna");
        assertEquals(1, array.getSize());
        assertEquals(1, array.getNumberOfElements());
    }

    @Test
    void addElementToFullArray() {
        var array = new UnsortedArray<String>(1);
        array.addElement("Anna");
        assertThrows(FullArrayException.class, () -> array.addElement("Maria"));
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

    @Test
    void removeElementFromEmptyArray() {
        var array = new UnsortedArray<String>(5);
        assertThrows(EmptyArrayException.class, () -> array.removeElement(0));
    }
}
