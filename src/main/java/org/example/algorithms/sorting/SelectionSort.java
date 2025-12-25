package org.example.algorithms.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class SelectionSort {

    public static List<Integer> sort(List<Integer> list) {
        if (list.isEmpty()) {
            return list;
        }
        List<Integer> original = new ArrayList<>(list);
        List<Integer> sorted = new ArrayList<>(list.size());
        while (!original.isEmpty()) {
            Integer smallest = findSmallest(original);
            sorted.add(smallest);
            original.remove(smallest);
        }
        return sorted;
    }

    private static int findSmallest(List<Integer> list) {
        ListIterator<Integer> iterator = list.listIterator();
        int smallest = list.getFirst();

        while (iterator.hasNext()) {
            int next = iterator.next();
            if (next < smallest) {
                smallest = next;
            }
        }

        return smallest;
    }
}
