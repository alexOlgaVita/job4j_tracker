package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    private int indexOf(int id) {
        int result = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                result = index;
                break;
            }
        }
        return result;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[items.length];
        int sizeResult = 0;
        for (int i = 0; i < size; i++) {
                if (items[i].getName().equals(key)) {
                    result[sizeResult++] = items[i];
                }
        }
        return Arrays.copyOf(result, sizeResult);
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean result = index != -1;
        /* поправлено здесь */
        if (result) {
            items[index] = item;
            items[index].setId(id);
        }
        return result;
    }

    public void delete(int id) {
        int i = indexOf(id);
        /* валидация выполнена */
        if (i != -1) {
            System.arraycopy(items, i + 1, items, i, size - i - 1);
            items[size - 1] = null;
            size--;
        }
    }
}