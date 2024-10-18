package ru.job4j.hashmap;

import java.util.List;

public record Pupil(String name, List<Subject> subjects) {
    public String getname() {
        return this.name;
    }
}
