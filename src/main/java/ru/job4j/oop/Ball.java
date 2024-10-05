package ru.job4j.oop;

public class Ball {

    public void tryRun(boolean condition) {
        String message = (condition) ? "The ball is eaten" : "The ball ran away";
        System.out.println(message);
    }
}
