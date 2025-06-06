package ru.job4j.hashmap;

public record Label(String name, double score) implements Comparable<Label> {
        public int compareTo(Label o) {
            return Double.compare(this.score, o.score);
        }
}
