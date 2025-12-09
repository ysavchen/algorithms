package org.example.algorithms.recursion;

public class Countdown {

    public static void main(String[] args) {
        countdown(10);
    }

    private static void countdown(int i) {
        System.out.println("print " + i);

        if (i <= 0) {
            return; // base case
        } else {
            countdown(i - 1); // recursion case
        }
    }
}
