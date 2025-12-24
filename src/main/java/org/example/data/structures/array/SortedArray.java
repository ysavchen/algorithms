package org.example.data.structures.array;

import java.util.Arrays;

/**
 * Отсортированный статический массив
 */
public class SortedArray<T> {

    private final T[] elementData;

    private static final int ELEMENT_NOT_FOUND = -1;

    private int numberOfElements = 0;

    private int newElementIndex = 0;

    public SortedArray(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be greater than 0");
        }
        this.elementData = (T[]) new Object[size];
    }

    public int getSize() {
        return elementData.length;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    @Override
    public String toString() {
        return Arrays.toString(elementData);
    }

}
