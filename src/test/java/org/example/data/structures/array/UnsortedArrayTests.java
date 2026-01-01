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
    void createArrayWithNegativeSize() {
        assertThrows(IllegalArgumentException.class, () -> new UnsortedArray<String>(-1));
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
        var element = "Anna";
        array.addElement(element);
        assertEquals(0, array.findElement(element));
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
    void deleteElement() {
        var array = new UnsortedArray<String>(1);
        array.addElement("Anna");
        assertEquals(1, array.getSize());
        assertEquals(1, array.getNumberOfElements());

        array.deleteByIndex(0);
        assertEquals(1, array.getSize());
        assertEquals(0, array.getNumberOfElements());
    }

    @Test
    void deleteElementFromEmptyArray() {
        var array = new UnsortedArray<String>(5);
        assertThrows(EmptyArrayException.class, () -> array.deleteByIndex(0));
    }
}
