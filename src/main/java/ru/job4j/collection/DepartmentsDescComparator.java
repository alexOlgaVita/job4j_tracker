package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        String[] leftS = left.split("/");
        String[] rightS = right.split("/");
        for (int i = 0; i < Math.min(leftS.length, rightS.length); i++) {
            for (int j = 0; j < Math.min(rightS[i].length() - 1, leftS[i].length() - 1); j++) {
                result = Character.compare(rightS[i].charAt(j), leftS[i].charAt(j));
            }
            if (result != 0) {
                return result;
            }
            result = Integer.compare(leftS[i].length(), rightS[i].length());
            if (result != 0) {
                return result;
            }
            result = (i == 0) ? Integer.compare(rightS[i].charAt(rightS[i].length() - 1), leftS[i].charAt(leftS[i].length() - 1)) : Integer.compare(leftS[i].charAt(leftS[i].length() - 1), rightS[i].charAt(rightS[i].length() - 1));
            if (result != 0) {
                return result;
            }

        }
        result = Integer.compare(leftS.length, rightS.length);
        return result;
    }
}
