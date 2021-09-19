package org.example.generics;

public class GenericMethod {

    private <K, V> void print(K key, V val) {
        System.out.println("key: " + key + ", val: " + val);
    }

    public static void main(String[] args) {
        var generics = new GenericMethod();
        generics.print(1, "one");
        generics.print("two", 2);
    }
}
