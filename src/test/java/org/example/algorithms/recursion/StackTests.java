package org.example.algorithms.recursion;

import org.example.data.structures.stack.exception.EmptyStackException;
import org.example.data.structures.stack.exception.FullStackException;
import org.example.data.structures.stack.Stack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackTests {

    @Test
    void createStackWithSize() {
        var stack = new Stack(1);
        stack.push(1);
        assertFalse(stack.isEmpty());
    }

    @Test
    void pushToFullStack() {
        var stack = new Stack(1);
        stack.push(1);
        assertThrows(FullStackException.class, () -> stack.push(2));
    }

    @Test
    void peekFromStack() {
        var stack = new Stack(2);
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.peek());
        assertEquals(1, stack.peek());
        assertTrue(stack.isEmpty());
    }

    @Test
    void peekFromEmptyStack() {
        var stack = new Stack(1);
        assertThrows(EmptyStackException.class, stack::peek);
    }

}
