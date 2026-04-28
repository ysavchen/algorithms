package org.example.data.structures.associative.array;

import java.util.Objects;

/**
 * Хеш-таблица на основе массива с разрешением конфликтов методом цепочек
 * <p>
 * Амортизированная сложность операций c хеш-таблицей составляет O(1).
 */
public class HashTable<K, V> implements Map<K, V> {

    private static class Node<K, V> {
        private final K key;
        private V value;

        private Node<K, V> next = null;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private record SearchResult<K, V>(Node<K, V> current, Node<K, V> previous) {
    }

    /**
     * Массив содержит бакеты, каждый бакет содержит список элементов.
     * <pre>{@code
     * 0 -> Node<K, V>
     * 1 -> Node<K, V>
     * 2 -> Node<K, V> -> Node<K, V>
     * }</pre>
     */
    private final Node<K, V>[] nodes;

    // todo: сделать увеличение размера хеш-таблицы
    /**
     * Простое число в качестве модуля дает равномерное распределение элементов по хеш-таблице
     */
    private static final int INITIAL_CAPACITY = 17;

    private int size;

    public HashTable() {
        this(INITIAL_CAPACITY);
    }

    public HashTable(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be greater than 0");
        }
        this.nodes = new Node[initialCapacity];
    }

    /**
     * Функция вычисляет нужный бакет хеш-таблицы
     *
     * @return int индекс бакета
     */
    private int bucket(int hashCode) {
        return Math.abs(hashCode) % nodes.length;
    }

    /**
     * Найденный элемент перемещается в начало цепочки (MTF)
     */
    @Override
    public V get(K key) {
        int index = bucket(key.hashCode());

        var result = search(key);
        if (result != null) {
            var current = result.current;
            var previous = result.previous;
            if (previous != null) {
                previous.next = current.next;
                current.next = nodes[index];
                nodes[index] = current;
            }
            return current.value;
        }

        return null;
    }

    @Override
    public boolean set(K key, V value) {
        if (key == null) {
            return false;
        }

        // если существует узел с таким ключом, то заменяем value
        var result = search(key);
        if (result != null) {
            result.current.value = value;
            return true;
        }

        // добавляем новый узел в начало списка
        var newNode = new Node<>(key, value);
        int index = bucket(key.hashCode());
        var head = nodes[index];
        if (head != null) {
            newNode.next = head;
        }
        nodes[index] = newNode;

        size++;
        return true;
    }

    @Override
    public boolean delete(K key) {
        int index = bucket(key.hashCode());

        var result = search(key);
        if (result != null) {
            if (result.previous != null) {
                result.previous.next = result.current.next;
            } else {
                nodes[index] = null;
            }
            size--;
            return true;
        }

        return false;
    }

    private SearchResult<K, V> search(K key) {
        int index = bucket(key.hashCode());
        Node<K, V> current = nodes[index];
        Node<K, V> previous = null;

        while (current != null) {
            if (current.key.equals(key)) {
                return new SearchResult<>(current, previous);
            }
            previous = current;
            current = current.next;
        }
        return null;
    }

    @Override
    public boolean contains(V value) {
        for (var current : nodes) {
            while (current != null) {
                if (Objects.equals(current.value, value)) {
                    return true;
                }
                current = current.next;
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
