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
        String nodeToFind = "claire";
        Map<String, List<String>> graph = Map.of(
                startVertex, List.of("alice", "bob", nodeToFind)
        );
        var fruitSellerSearch = new BreadthFirstSearch(graph);
        var result = fruitSellerSearch.search(startVertex, name -> name.equals(nodeToFind));
        assertEquals(nodeToFind, result);
    }

    @Test
    void bfsSecondRoundVertices() {
        String nodeToFind = "thom";
        Map<String, List<String>> graph = Map.of(
                startVertex, List.of("alice", "bob", "claire"),
                "bob", List.of("ria", "jonny"),
                "alice", List.of("emma"),
                "claire", List.of(nodeToFind, "ann")
        );
        var mangoSellerSearch = new BreadthFirstSearch(graph);
        var result = mangoSellerSearch.search(startVertex, name -> name.equals(nodeToFind));
        assertEquals(nodeToFind, result);
    }

    @Test
    void bfsDuplicateVertices() {
        String nodeToFind = "thom";
        Map<String, List<String>> graph = Map.of(
                startVertex, List.of("alice", "bob", "claire"),
                "bob", List.of("ria", "jonny"),
                "alice", List.of("emma"),
                "claire", List.of("you")
        );
        var mangoSellerSearch = new BreadthFirstSearch(graph);
        assertTimeoutPreemptively(ofMillis(100), () -> {
            String result = mangoSellerSearch.search(startVertex, name -> name.equals(nodeToFind));
            assertEquals(result, NOT_FOUND);
        });
    }

    @Test
    void bfsNotFound() {
        String nodeToFind = "daniel";
        Map<String, List<String>> graph = Map.of(
                startVertex, List.of("alice", "bob", "claire"),
                "bob", List.of("ria", "jonny"),
                "alice", List.of("emma"),
                "claire", List.of("ann")
        );
        var mangoSellerSearch = new BreadthFirstSearch(graph);
        var result = mangoSellerSearch.search(startVertex, name -> name.equals(nodeToFind));
        assertEquals(NOT_FOUND, result);
    }
}
