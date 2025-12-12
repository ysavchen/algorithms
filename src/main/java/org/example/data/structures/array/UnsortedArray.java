package org.example.data.structures.array;

import java.util.Arrays;

// 1. Убрать индекс из setElement()
// 2. Поддерживать выравнивание по левому краю
public class UnsortedArray<T> {

    private final T[] elementData;

    private int numberOfElements;

    public UnsortedArray(int size) {
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

    public T getElement(int index) {
        if (index < 0 || index >= elementData.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return elementData[index];
    }

    public void setElement(int index, T element) {
        if (index < 0 || index >= elementData.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        elementData[index] = element;
        numberOfElements++;
    }

    public void removeElement(int index) {
        elementData[index] = null;
        numberOfElements--;
    }

    @Override
    public String toString() {
        return Arrays.toString(elementData);
    }
}
