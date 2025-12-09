package com.example.algorithms.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class BreadthFirstSearch {

    private final Map<String, List<String>> graph;
    private static final String NOT_FOUND = "not found";

    public BreadthFirstSearch(Map<String, List<String>> graph) {
        this.graph = graph;
    }

    public String search(String startVertex, Function<String, Boolean> isFound) {
        var searchQueue = new ArrayDeque<>(graph.get(startVertex));
        var searched = new ArrayList<String>();

        while (!searchQueue.isEmpty()) {
            String person = searchQueue.poll();
            if (!searched.contains(person)) {
                if (isFound.apply(person)) {
                    System.out.println(person + " is found!");
                    return person;
                } else {
                    List<String> personEdges = graph.get(person);
                    if (personEdges != null) {
                        searchQueue.addAll(graph.get(person));
                    }
                    searched.add(person);
                }
            }
        }

        return NOT_FOUND;
    }
}
