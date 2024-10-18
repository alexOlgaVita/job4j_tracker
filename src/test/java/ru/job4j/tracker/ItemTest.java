package ru.job4j.tracker;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemTest {
    @Test
    void itemAscByName() {
        Item item1 =  new Item("Даша");
        Item item2 =  new Item("Дарья");
        Item item3 =  new Item("Данил");
        List<Item> items = new ArrayList<>(Arrays.asList(
                item1,
                item2,
                item3)
        );
        List<Item> expected = new ArrayList<>(Arrays.asList(
                item3,
                item2,
                item1)
        );

        Collections.sort(items, new ItemAscByName());
        assertThat(items).isEqualTo(expected);
    }

    @Test
    void itemDescByName() {
        Item item1 =  new Item("Даша");
        Item item2 =  new Item("Данил");
        Item item3 =  new Item("Дарья");
        List<Item> items = new ArrayList<>(Arrays.asList(
                item1,
                item2,
                item3)
        );
        List<Item> expected = new ArrayList<>(Arrays.asList(
                item1,
                item3,
                item2)
        );

        Collections.sort(items, new ItemDescByName());
        assertThat(items).isEqualTo(expected);
    }
}