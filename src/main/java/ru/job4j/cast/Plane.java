package ru.job4j.cast;

public class Plane implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " летает в небе");
    }

    @Override
    public void stop() {
        System.out.println(getClass().getSimpleName() + " идет на посадку");
    }
}
