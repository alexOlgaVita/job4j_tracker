package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        String name = "Clean code";
        Book cleanArchitecture = new Book("Clean Architecture: A Craftsman's Guide to Software", 293);
        Book functionalDesign = new Book("Functional Design: Principles, Patterns, and Practices", 317);
        Book cleanCode = new Book("Clean code", 210);
        Book extremeProgramming = new Book("Extreme Programming in Practice", 186);
        Book[] books = new Book[4];
        books[0] = cleanArchitecture;
        books[1] = functionalDesign;
        books[2] = cleanCode;
        books[3] = extremeProgramming;
        System.out.println("Список книг до перестановки:");
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println("\"" + book.getName() + "\", количество страниц: " + book.getPages());
        }
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        System.out.println("Список книг после перестановки:");
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println("\"" + book.getName() + "\", количество страниц: " + book.getPages());
        }
        System.out.println("Книги только с названием = \"Clean code\"");
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            if (book.getName().equals(name)) {
                System.out.println("\"" + book.getName() + "\", количество страниц: " + book.getPages());
            }
        }
    }
}
