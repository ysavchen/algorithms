package org.example.data.structures.array;

import org.example.data.structures.array.exception.ElementNotFoundException;
import org.example.data.structures.array.exception.EmptyArrayException;
import org.example.data.structures.array.exception.FullArrayException;

import java.util.Arrays;
import java.util.function.Consumer;

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

    public T getMaxElement() {
        throw new RuntimeException();
    }

    public T getMinElement() {
        throw new RuntimeException();
    }

    public int findElement(T element) {
        for (int index = 0; index < elementData.length; index++) {
            var arrayElement = elementData[index];
            if (arrayElement == null ? element == null : elementData[index].equals(element)) {
                return index;
            }
        }
        throw new ElementNotFoundException();
    }

    public void traverse(Consumer<T> consumer) {
        for (T element : elementData) {
            consumer.accept(element);
        }
    }

    public void addElement(T element) {
        if (elementData.length == numberOfElements) {
            throw new FullArrayException();
        }
        elementData[newElementIndex] = element;
        numberOfElements++;
        newElementIndex++;
    }

    /**
     * Поддерживается выравнивание массива по левому краю,
     * и если требуется удалить элемент из середины массива, то такое удаление оставит пропуск посреди блока элементов.<br/>
     * Т.к. массив не отсортирован, то можно поменять местами последний элемент с удаляемым.<br/>
     * И затем удалить последний элемент.
     */
    public void removeByIndex(int index) {
        if (numberOfElements == 0) {
            throw new EmptyArrayException();
        } else if (index < 0 || index >= newElementIndex) {
            throw new IndexOutOfBoundsException();
        } else {
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
