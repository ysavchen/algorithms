package org.example.algorithms.bfs;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

public class BreadthFirstSearchTests {

    private static final String startVertex = "you";
    private static final String NOT_FOUND = "not found";

    @Test
    void bfsFirstRoundVertices() {
        String vertexToFind = "claire";
        Map<String, List<String>> graph = Map.of(
            startVertex, List.of("alice", "bob", vertexToFind)
        );
        var vertexSearch = new BreadthFirstSearch(graph);
        var result = vertexSearch.search(startVertex, name -> name.equals(vertexToFind));
        assertEquals(vertexToFind, result);
    }

    @Test
    void bfsSecondRoundVertices() {
        String vertexToFind = "thom";
        Map<String, List<String>> graph = Map.of(
            startVertex, List.of("alice", "bob", "claire"),
            "bob", List.of("ria", "jonny"),
            "alice", List.of("emma"),
            "claire", List.of(vertexToFind, "ann")
        );
        var vertexSearch = new BreadthFirstSearch(graph);
        var result = vertexSearch.search(startVertex, name -> name.equals(vertexToFind));
        assertEquals(vertexToFind, result);
    }

    @Test
    void bfsDuplicateVertices() {
        String vertexToFind = "thom";
        Map<String, List<String>> graph = Map.of(
            startVertex, List.of("alice", "bob", "claire"),
            "bob", List.of("ria", "jonny"),
            "alice", List.of("emma"),
            "claire", List.of("you")
        );
        var vertexSearch = new BreadthFirstSearch(graph);
        assertTimeoutPreemptively(ofMillis(100), () -> {
            String result = vertexSearch.search(startVertex, name -> name.equals(vertexToFind));
            assertEquals(result, NOT_FOUND);
        });
    }

    @Test
    void bfsNotFound() {
        String vertexToFind = "daniel";
        Map<String, List<String>> graph = Map.of(
            startVertex, List.of("alice", "bob", "claire"),
            "bob", List.of("ria", "jonny"),
            "alice", List.of("emma"),
            "claire", List.of("ann")
        );
        var vertexSearch = new BreadthFirstSearch(graph);
        var result = vertexSearch.search(startVertex, name -> name.equals(vertexToFind));
        assertEquals(NOT_FOUND, result);
    }
}
