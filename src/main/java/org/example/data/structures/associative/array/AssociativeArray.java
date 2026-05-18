package org.example.data.structures.associative.array;

import java.util.Objects;

/**
 * Ассоциативный массив со сложностью операций O(n)
 */
public class AssociativeArray<K, V> implements Map<K, V> {

    private static class Pair<K, V> {
        private final K key;
        private V value;

        Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * Массив содержит бакеты, каждый бакет содержит элемент.<br/>
     * В случае коллизии элемент затирается новой записью.
     * <pre>{@code
     * 0 -> Pair<K, V>
     * 1 -> Pair<K, V>
     * 2 -> Pair<K, V>
     * }</pre>
     */
    private final Pair<K, V>[] pairs;

    private static final int INITIAL_CAPACITY = 17;

    private int size;

    public AssociativeArray() {
        this.pairs = new Pair[INITIAL_CAPACITY];
    }

    @Override
    public V get(K key) {
        for (Pair<K, V> pair : pairs) {
            if (pair == null) {
                break;
            }

            if (Objects.equals(pair.key, key)) {
                return pair.value;
            }
        }
        return null;
    }

    @Override
    public boolean set(K key, V value) {
        for (Pair<K, V> pair : pairs) {
            if (pair == null) {
                break;
            }

            if (Objects.equals(pair.key, key)) {
                pair.value = value;
                return true;
            }
        }

        Pair<K, V> pair = new Pair<>(key, value);
        pairs[size] = pair;
        size++;
        return true;
    }

    @Override
    public boolean delete(K key) {
        int index = 0;
        for (Pair<K, V> pair : pairs) {
            if (pair == null) {
                break;
            }

            if (Objects.equals(pair.key, key)) {
                int lastElementIndex = size - 1;
                if (index == lastElementIndex) {
                    pairs[index] = null;
                } else {
                    pairs[index] = pairs[lastElementIndex];
                    pairs[lastElementIndex] = null;
                }
                size--;
                return true;
            }
            index++;
        }
        return false;
    }

    @Override
    public boolean contains(V value) {
        for (Pair<K, V> pair : pairs) {
            if (pair == null) {
                break;
            }

            if (Objects.equals(pair.value, value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }
}
