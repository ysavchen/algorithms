package org.example.data.structures.array;

import java.util.Arrays;

// 1. findElement(T element)
// 2. traverse()
public class UnsortedArray<T> {

    private final T[] elementData;

    private int numberOfElements = 0;

    private int newElementIndex = 0;

    public UnsortedArray(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be greater than 0");
        }
        this.elementData = (T[]) new Object[size];
    }

    public T getElement(int index) {
        if (index < 0 || index >= elementData.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return elementData[index];
    }

    public void addElement(T element) {
        elementData[newElementIndex] = element;
        numberOfElements++;
        newElementIndex++;
    }

    public void removeElement(int index) {
        int lastElementIndex = newElementIndex - 1;
        if (index == lastElementIndex) {
            elementData[index] = null;
        } else {
            elementData[index] = elementData[lastElementIndex];
            elementData[lastElementIndex] = null;
        }
        numberOfElements--;
        newElementIndex--;
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
