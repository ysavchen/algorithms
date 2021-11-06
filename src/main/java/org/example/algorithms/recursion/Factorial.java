package org.example.algorithms.recursion;

public class Factorial {

    public static void main(String[] args) {
        int result = fact(3);
        System.out.println("Result: " + result);
    }

    private static int fact(int x) {
        if (x == 1) {
            return 1;
        } else {
            return x * fact(x - 1);
        }
    }
}
