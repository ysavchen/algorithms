package com.example.algorithms.quicksort;

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

        int pivotElementIndex = 1;
        Integer pivot = listCopy.get(pivotElementIndex);
        listCopy.remove(pivotElementIndex);
        List<Integer> less = sort(
                listCopy.stream()
                        .filter(element -> element <= pivot)
                        .toList()
        );
        List<Integer> more = sort(
                listCopy.stream()
                        .filter(element -> element > pivot)
                        .toList()
        );

        return Stream.of(less.stream(), Stream.of(pivot), more.stream())
                .flatMap(Function.identity())
                .toList();
    }
}
