package org.example.data.structures.array;

public class ArrayMain {

    public static void main(String[] args) {
        var array = new StringArray(3);
        array.setElement(0, "Anna");
        array.setElement(1, "Maria");
        array.setElement(2, "Elena");
        System.out.println(array);
    }
}
