package org.example.data.structures.array;

import java.util.Arrays;

public class StringArray {

    private final String[] elementData;

    public StringArray(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be greater than 0");
        }
        this.elementData = new String[size];
    }

    public int getSize() {
        return elementData.length;
    }

    public String getElement(int index) {
        if (index < 0 || index >= elementData.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return elementData[index];
    }

    public void setElement(int index, String element) {
        if (index < 0 || index >= elementData.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        elementData[index] = element;
    }

    @Override
    public String toString() {
        return Arrays.toString(elementData);
    }
}
