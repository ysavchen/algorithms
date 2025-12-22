package org.example.data.structures.array;

public class ArrayMain {

    public static void main(String[] args) {
        var array = new UnsortedArray<String>(3);
        array.addElement("Anna");
        array.addElement("Maria");
        array.addElement("Elena");
        System.out.println(array.getNumberOfElements());
    }
}
