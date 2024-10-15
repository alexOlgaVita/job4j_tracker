package ru.job4j.tracker;

import java.util.ArrayList;

public class Tracker {
    private final ArrayList<Item> items = new ArrayList<>();
    private int ids = 1;

    private int indexOf(int id) {
        int result = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                result = index;
                break;
            }
        }
        return result;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> result = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
                if (items.get(i).getName().equals(key)) {
                    result.add(items.get(i));
                }
        }
        return result;
    }

    public ArrayList<Item> findAll() {
        return items;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            item.setId(id);
            items.add(index, item);
        }
        return result;
    }

    public void delete(int id) {
        int i = indexOf(id);
        /* валидация выполнена */
        if (i != -1) {
            items.remove(i);
        }
    }
}