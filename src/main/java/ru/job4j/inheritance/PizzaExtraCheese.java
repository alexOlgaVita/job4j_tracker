package ru.job4j.inheritance;

public class PizzaExtraCheese extends Pizza {
    private static final String EXTRA_CHEESE = "Cheese";

    @Override
    public String name() {
        return super.name() + " with top " + EXTRA_CHEESE;
    }
}
