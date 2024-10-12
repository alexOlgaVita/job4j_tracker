package ru.job4j.ex;

public class Factorial {
    public static int calc(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else if (n > 1) {
            return calc(n - 1) * n;
        }
        throw new IllegalArgumentException("Number could not be less than 0");
    }

    public static void main(String[] args) {
        int result = calc(3);
        System.out.println(result);
    }
}
