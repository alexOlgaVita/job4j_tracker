package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        int lMin = Math.min(left.length(), right.length());
        int lMax = Math.max(left.length(), right.length());
        for (int index = 0; index < lMin; index++) {
                result = left.charAt(index) - right.charAt(index);
            if (result != 0) {
                break;
            }
        }
        if (result == 0 && lMin != lMax) {
            result = (lMin < right.length()) ? -right.charAt(left.length()) : left.charAt(right.length());
        }
        return result;
    }
}
