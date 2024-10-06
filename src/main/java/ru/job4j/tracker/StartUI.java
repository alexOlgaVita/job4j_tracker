package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] arg) {
        Item item = new Item();
        LocalDateTime created = item.getCreated();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String currentDateTimeFormat = created.format(formatter);
        System.out.println("Дата и время создания объекта: " + currentDateTimeFormat);
        System.out.println(item);
    }
}
