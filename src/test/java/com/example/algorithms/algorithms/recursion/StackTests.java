package com.example.algorithms.algorithms.recursion;

import com.example.algorithms.recursion.Stack;
import com.example.algorithms.recursion.exception.EmptyStackException;
import com.example.algorithms.recursion.exception.FullStackException;
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
