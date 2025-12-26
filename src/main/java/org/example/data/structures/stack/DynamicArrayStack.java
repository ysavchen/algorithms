package org.example.data.structures.stack;

import org.example.data.structures.stack.exception.EmptyStackException;
import org.example.data.structures.stack.exception.FullStackException;

/**
 * Стек на основе динамического массива
 */
public class DynamicArrayStack {

    private final int[] stack;
    private int pushIndex;

    public DynamicArrayStack(int size) {
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
