package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("olilijna@mail.ru", "Olga Ilyina");
        map.put("svetakonfeta0901@gmail.com", "Olga Ilyina");
        map.put("kolapro522@gmail.com", "Olga Ilyina");
        for (String key : map.keySet()) {
            System.out.println("key = " + key + ", value = " + map.get(key));
        }
    }
}
