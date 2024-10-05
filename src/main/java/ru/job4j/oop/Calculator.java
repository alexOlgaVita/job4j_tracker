package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int y) {
        return x * y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public double divide(int y) {
        return y / x;
    }

    public double sumAllOperation(int y) {
        return sum(y) + multiply(y) + minus(y) + divide(y);
    }

    public static void main(String[] args) {
        int z = 10;
        Calculator y = new Calculator();
        System.out.println("Математические операции с числом: " + z);
        System.out.println("sum = " + sum(z));
        System.out.println("multiply = " + y.multiply(z));
        System.out.println("minus = " + minus(z));
        System.out.println("divide = " + y.divide(z));
        System.out.println("sumAllOperation = " + y.sumAllOperation(z));
    }
}
