package ru.job4j.collection;

public class Task {
    private String number;
    private String description;

    public Task(String number, String description) {
        this.number = number;
        this.description = description;
    }

    public String getNumber() {
        return number;
    }

    // Включите этот метод, если понадобится описание задачи
    public String getDescription() {
        return description;
    }
}
