package ru.job4j.hashmap;

public record Subject(String name, int score) {
    public int getScore() {
        return this.score;
    }

    public String getname() {
        return this.name;
    }
}
