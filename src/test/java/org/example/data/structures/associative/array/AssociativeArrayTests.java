package org.example.data.structures.associative.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AssociativeArrayTests {

    @Test
    void createAssociativeArray() {
        var array = new AssociativeArray<String, String>();
        assertTrue(array.isEmpty());
    }

    @Test
    void setValue() {
        var array = new AssociativeArray<String, String>();
        array.set("first", "Anna");
        assertEquals(1, array.getSize());

        array.set("second", "Maria");
        assertEquals(2, array.getSize());
    }

    @Test
    void replaceValue() {
        var array = new AssociativeArray<String, String>();
        array.set("first", "Anna");
        assertEquals(1, array.getSize());

        array.set("first", "Maria");
        assertEquals("Maria", array.get("first"));
        assertEquals(1, array.getSize());
    }

    @Test
    void getValue() {
        var array = new AssociativeArray<String, String>();
        array.set("first", "Anna");
        assertEquals("Anna", array.get("first"));
        assertEquals(1, array.getSize());
    }

    @Test
    void getValueByNonExistingKey() {
        var array = new AssociativeArray<String, String>();
        assertNull(array.get("first"));
    }

    @Test
    void containsValue() {
        var array = new AssociativeArray<String, String>();
        array.set("first", "Anna");
        assertTrue(array.contains("Anna"));
        assertFalse(array.contains("Maria"));
    }

    @Test
    void deleteValue() {
        var array = new AssociativeArray<String, String>();
        array.set("first", "Anna");
        assertTrue(array.delete("first"));
    }

    @Test
    void deleteFirstValue() {
        var array = new AssociativeArray<String, String>();
        array.set("first", "Anna");
        array.set("second", "Maria");
        assertTrue(array.delete("first"));
    }

    @Test
    void deleteValueByNonExistingKey() {
        var array = new AssociativeArray<String, String>();
        array.set("first", "Anna");
        assertFalse(array.delete("second"));
    }
}
