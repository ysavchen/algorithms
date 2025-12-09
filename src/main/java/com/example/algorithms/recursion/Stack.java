package com.example.algorithms.recursion;

import com.example.algorithms.recursion.exception.EmptyStackException;
import com.example.algorithms.recursion.exception.FullStackException;

public class Stack {

    private final int[] stack;
    private int pushIndex;

    public Stack(int size) {
        this.stack = new int[size];
    }

    public void push(int item) {
        if (stack.length == pushIndex) {
            throw new FullStackException();
        }
        stack[pushIndex] = item;
        pushIndex++;
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int lastElementIndex = --pushIndex;
        return stack[lastElementIndex];
    }

    public boolean isEmpty() {
        return pushIndex == 0;
    }
}
