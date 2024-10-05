package ru.job4j.inheritance;

public class PizzaExtraCheeseExtraTomato extends PizzaExtraCheese {
    private static final String EXTRA_TOMATO = "Tomato";

    @Override
    public String name() {
        return super.name() + " and " + EXTRA_TOMATO;
    }
}
