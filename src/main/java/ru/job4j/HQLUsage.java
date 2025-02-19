package ru.job4j;

import ru.job4j.tracker.HbmTracker;
import ru.job4j.tracker.Item;

import java.time.LocalDateTime;

public class HQLUsage {
    public static void main(String[] args) {
        var hbmTracker = new HbmTracker();
        var item = new Item();
        item.setName("admin");
        item.setCreated(LocalDateTime.of(2025, 02, 19, 19, 33, 22));
        hbmTracker.add(item);
        hbmTracker.findAll()
                .forEach(System.out::println);
        System.out.println(hbmTracker.findById(item.getId()));
        System.out.println(hbmTracker.findByName("admin"));
        item.setCreated(LocalDateTime.of(2025, 02, 19, 23, 59, 58));
        hbmTracker.replace(item.getId(), item);
        System.out.println(hbmTracker.findById(item.getId()));
        hbmTracker.delete(item.getId());
        hbmTracker.findAll()
                .forEach(System.out::println);
    }
}
