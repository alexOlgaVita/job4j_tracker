package ru.job4j.stream;

import java.util.List;
import java.util.Objects;

public class StudentLevel {
    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .filter(Objects::nonNull)
                .sorted((left, right) -> (right.getScore() - left.getScore()))
                .takeWhile(student -> student.getScore() >= bound)
                .toList();
    }
}