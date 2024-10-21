package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] leftS = left.split("/");
        String[] rightS = right.split("/");
        int result = rightS[0].compareTo(leftS[0]);
        return result != 0 ? result : left.compareTo(right);
    }
}
