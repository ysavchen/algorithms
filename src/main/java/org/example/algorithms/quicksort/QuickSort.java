package org.example.algorithms.quicksort;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class QuickSort {

    public static List<Integer> sort(List<Integer> list) {
        List<Integer> listCopy = new ArrayList<>(list);
        if (listCopy.size() < 2) {
            return listCopy;
        }

        int baseElementIndex = 1;
        Integer base = listCopy.get(baseElementIndex);
        listCopy.remove(baseElementIndex);
        List<Integer> less = sort(
                listCopy.stream()
                        .filter(element -> element <= base)
                        .toList()
        );
        List<Integer> more = sort(
                listCopy.stream()
                        .filter(element -> element > base)
                        .toList()
        );

        return Stream.of(less.stream(), Stream.of(base), more.stream())
                .flatMap(Function.identity())
                .toList();
    }
}
