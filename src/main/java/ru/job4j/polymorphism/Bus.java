package ru.job4j.polymorphism;

public class Bus implements Transport {

    @Override
    public void move() {
        System.out.println("Поехали!");
    }

    @Override
    public void passengers(int count) {
        System.out.println("Автобус рассчитан количество пассажиров = " + count);
    }

    @Override
    public int refuel(int fuel) {
        return 0;
    }
}
