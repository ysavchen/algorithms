package org.example.data.structures.associative.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HashTableTests {

    @Test
    void createHashTable() {
        var table = new HashTable<String, String>();
        assertEquals(0, table.getSize());
    }

    @Test
    void setElement() {
        var table = new HashTable<String, String>();

        boolean annaResult = table.set("first", "Anna");
        assertEquals(1, table.getSize());
        assertTrue(annaResult);

        boolean mariaResult = table.set("second", "Maria");
        assertEquals(2, table.getSize());
        assertTrue(mariaResult);
    }

    @Test
    void setNullElement() {
        var table = new HashTable<String, String>();

        boolean firstResult = table.set("first", null);
        assertEquals(1, table.getSize());
        assertTrue(firstResult);

        boolean secondResult = table.set("second", null);
        assertEquals(2, table.getSize());
        assertTrue(secondResult);
    }

    @Test
    void setByNullKey() {
        var table = new HashTable<String, String>();
        boolean annaResult = table.set(null, "Anna");
        assertEquals(0, table.getSize());
        assertFalse(annaResult);
    }

    @Test
    void getElement() {
        var table = new HashTable<String, String>();
        table.set("first", "Anna");
        assertEquals("Anna", table.get("first"));
    }

    @Test
    void getElementByNonExistingKey() {
        var table = new HashTable<String, String>();
        assertNull(table.get("first"));
    }
}
