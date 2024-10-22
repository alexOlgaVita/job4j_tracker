package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double result = 0D;
        int count = 0;
        for (Pupil pupil : pupils) {
             for (Subject subject : pupil.subjects()) {
                 count++;
                 result += subject.getScore();
             }
        }
        result = (result / count);
        return result;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label>  listResult = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double result = 0D;
            int count = 0;
            for (Subject subject : pupil.subjects()) {
                count++;
                result += subject.getScore();
            }
            listResult.add(new Label(pupil.getname(), result / count));
        }
        return listResult;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> subjMap = new LinkedHashMap<>();
        List<Label>  listResult = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                subjMap.merge(subject.getname(), subject.getScore(), (oldValue, newValue) -> oldValue + subject.getScore());
            }
        }
        for (Map.Entry<String, Integer> entry : subjMap.entrySet()) {
            listResult.add(new Label(entry.getKey(), (double) entry.getValue() / pupils.size()));
        }
        return listResult;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label>  listResult = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double result = 0D;
            for (Subject subject : pupil.subjects()) {
                result += subject.getScore();
            }
            listResult.add(new Label(pupil.getname(), result));
        }
        Collections.sort(listResult);
        return listResult.get(listResult.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> subjMap = new LinkedHashMap<>();
        List<Label>  listResult = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                subjMap.merge(subject.getname(), subject.getScore(), (oldValue, newValue) -> oldValue + subject.getScore());
            }
        }
        for (Map.Entry<String, Integer> entry : subjMap.entrySet()) {
            listResult.add(new Label(entry.getKey(), entry.getValue()));
        }
        Collections.sort(listResult);
        return listResult.get(listResult.size() - 1);
    }
}
