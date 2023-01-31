package com.example.recursion.factorial;

public class Factorial {

    private static int callStack = 0;
    public static void main(String[] args) {

        System.out.printf("factorial(%d): %d, Stack calls: %d\n", 5, factorial(5), callStack);
        callStack = 0;
        System.out.printf("factorial(%d): %d, Stack calls: %d\n", 10, factorial(10), callStack);
    }

    // n! = n * (n - 1)!
    static long factorial(int n) {
        // stack calls grow as n grows
        callStack++;
        // breaking condition, also known as
        if (n == 0) {     // base case, to prevent stack overflow!
            return 1;
        } else {
            return n * factorial(n - 1);    // recursive call
        }
    }

    // an iterative solution would be faster
    // there's also a limit of calls in the stack
}
