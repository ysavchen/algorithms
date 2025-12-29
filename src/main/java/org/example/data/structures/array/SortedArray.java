package org.example.data.structures.array;

import org.example.data.structures.array.exception.FullArrayException;

import java.util.Arrays;
import java.util.Objects;

/**
 * Отсортированный статический массив
 */
public class SortedArray<T extends Comparable<T>> {

    private final T[] elementData;

    private static final int ELEMENT_NOT_FOUND = -1;

    private int numberOfElements = 0;

    private int emptyCellIndex = 0;

    public SortedArray(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be greater than 0");
        }
        this.elementData = (T[]) new Comparable[size];
    }

    public T getElement(int index) {
        if (index < 0 || index >= elementData.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return elementData[index];
    }

    public int findElement(T element) {
        //todo: update as an array is sorted
        for (int index = 0; index < elementData.length; index++) {
            var arrayElement = elementData[index];
            if (Objects.equals(arrayElement, element)) {
                return index;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    /**
     * При добавлении нового элемента в массив, находим правильную позицию для вставки, чтобы не нарушался порядок сортировки.
     */
    public void addElement(T element) {
        if (elementData.length == numberOfElements) {
            throw new FullArrayException();
        }

        if (emptyCellIndex == 0) { // array is empty
            elementData[emptyCellIndex] = element;
        } else {
            // обходим элементы массива, начиная с последнего, и сравниваем вставляемый элемент с предыдущим
            for (int i = emptyCellIndex; i > 0; i--) {
                var prevElement = elementData[i - 1];
                int result = element.compareTo(prevElement);
                if (result < 0) {  // prevElement is greater than element
                    elementData[i] = prevElement;
                    elementData[i - 1] = element;
                } else {
                    elementData[i] = element;
                    break;
                }
            }
        }

        emptyCellIndex++;
        numberOfElements++;
    }

    public void removeByIndex(int index) {

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
