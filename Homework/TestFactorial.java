package Homework;

import java.util.Scanner;

public class TestFactorial {
    public static Scanner kb = new Scanner(System.in);

    public static void main(String[] args) {
        int N, result;
        System.out.println("Testing Recursion\n");
        System.out.print("Enter N: ");
        N = kb.nextInt();
        result = factorial(N);
        System.out.println("Result = " + result);
    }

    public static int factorial(int N) {
        int result;
        System.out.println("in: " + N);
        if (N > 1)
            result = N * factorial(N - 1);
        else
            result = 1;
        System.out.println("out: " + result);
        return result;
    }
}
