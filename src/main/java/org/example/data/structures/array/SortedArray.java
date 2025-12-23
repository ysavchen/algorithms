package org.example.data.structures.array;

public class SortedArray<T> {

    private final T[] elementData;

    public SortedArray(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be greater than 0");
        }
        this.elementData = (T[]) new Object[size];
    }

}
