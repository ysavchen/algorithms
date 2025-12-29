package org.example.data.structures.array;

public class Main {

    public static void main(String[] args) {
        var array = new SortedArray<String>(3);
        array.addElement("Maria");
        array.addElement("Elena");
        array.addElement("Anna");
        System.out.println(array);
    }
}
