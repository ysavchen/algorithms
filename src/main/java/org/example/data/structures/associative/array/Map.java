package org.example.data.structures.associative.array;

public interface Map<K, V> {

    V get(K key);

    boolean set(K key, V value);

    boolean delete(K key);

    boolean contains(V value);

    boolean isEmpty();

    int getSize();

}
