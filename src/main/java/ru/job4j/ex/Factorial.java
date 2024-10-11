package ru.job4j.ex;

public class Factorial {
    public static int calc(int n) {
        int result = 1;
        if (n > 1) {
                result = calc(n - 1) * n;
        } else if (n < 0) {
            throw new IllegalArgumentException("Number could not be less than 0");
        }
        return result;
    }

    public static void main(String[] args) {
        int result = calc(3);
        System.out.println(result);
    }
}
