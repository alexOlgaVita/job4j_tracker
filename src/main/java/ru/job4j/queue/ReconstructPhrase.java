package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder result = new StringBuilder();
        int count = this.evenElements.size();
        for (int i = 0; i < count; i++) {
            Character c = this.evenElements.poll();
            if (i % 2 == 0) {
                result.append(c);
            }
        }
        return result.toString();
    }

    private String getDescendingElements() {
        StringBuilder result = new StringBuilder();
        int count = this.descendingElements.size();
        for (int i = 0; i < count; i++) {
            Character c = this.descendingElements.pollLast();
            result.append(c);
        }
        return result.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
