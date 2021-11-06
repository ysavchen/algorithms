package org.example.algorithms.sorting;

import org.example.algorithms.sorting.SelectionSort;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SelectionSortTests {

    @Test
    void selectionSort() {
        var immutable = List.of(9, 14, 2, 5);
        var actual = SelectionSort.sort(immutable);
        var expected = new ArrayList<>(immutable);
        Collections.sort(expected);
        assertEquals(expected, actual);
    }

    @Test
    void sortEmptyList() {
        List<Integer> immutable = Collections.emptyList();
        List<Integer> sorted = SelectionSort.sort(immutable);
        assertTrue(sorted.isEmpty());
    }
}
