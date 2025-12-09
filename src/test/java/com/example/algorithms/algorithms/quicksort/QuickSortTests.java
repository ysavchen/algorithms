package com.example.algorithms.algorithms.quicksort;

import com.example.algorithms.quicksort.QuickSort;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QuickSortTests {

    @Test
    void quickSort() {
        var immutable = List.of(9, 14, 2, 5, 53, 1);
        var actual = QuickSort.sort(immutable);
        var expected = new ArrayList<>(immutable);
        Collections.sort(expected);
        assertEquals(expected, actual);
    }

    @Test
    void quickSortSameElements() {
        var immutable = List.of(1, 1, 1);
        var actual = QuickSort.sort(immutable);
        var expected = new ArrayList<>(immutable);
        Collections.sort(expected);
        assertEquals(expected, actual);
    }

    @Test
    void sortEmptyList() {
        List<Integer> immutable = Collections.emptyList();
        List<Integer> sorted = QuickSort.sort(immutable);
        assertTrue(sorted.isEmpty());
    }
}
