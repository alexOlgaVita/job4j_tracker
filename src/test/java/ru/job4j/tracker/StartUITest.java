package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.action.*;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.MockInput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {
    @Test
    void whenCreateItem() {
        Output output = new StubOutput();
        Input input = new MockInput(
                new String[]{"0", "Item name", "1"}
        );
        MemTracker tracker = new MemTracker();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll().get(0).getName()).isEqualTo("Item name");
    }

    @Test
    void whenReplaceItem() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input input = new MockInput(
                new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ReplaceAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo(replacedName);
    }

    @Test
    void whenDeleteItem() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input input = new MockInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new DeleteAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    void whenExit() {
        Output output = new StubOutput();
        Input input = new MockInput(
                new String[]{"0"}
        );
        MemTracker tracker = new MemTracker();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction(output));
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString()).isEqualTo(
                "Меню:" + System.lineSeparator()
                        + "0. Завершить программу" + System.lineSeparator()
                        + "=== Завершение программы ===" + System.lineSeparator()
        );
    }

    @Test
    void whenSomeItemsFindAll() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item[] items = new Item[4];
        for (int i = 0; i < 4; i++) {
            items[i] = tracker.add(new Item("Item" + i));
        }
        Input input = new MockInput(
                new String[]{"0", "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new FindAllAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(input, tracker, actions);
        StringBuilder allItemsPrint = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            allItemsPrint.append(tracker.findById(items[i].getId()).toString()).append(System.lineSeparator());
        }
        assertThat(output.toString()).isEqualTo(
                "Меню:" + System.lineSeparator()
                        + "0. Показать все заявки" + System.lineSeparator()
                        + "1. Завершить программу" + System.lineSeparator()
                        + "=== Вывод всех заявок ===" + System.lineSeparator()
                        + allItemsPrint
                        + "Меню:" + System.lineSeparator()
                        + "0. Показать все заявки" + System.lineSeparator()
                        + "1. Завершить программу" + System.lineSeparator()
                        + "=== Завершение программы ===" + System.lineSeparator()
        );
    }

    @Test
    void whenNotItemsFindAll() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Input input = new MockInput(
                new String[]{"0", "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new FindAllAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString()).isEqualTo(
                "Меню:" + System.lineSeparator()
                        + "0. Показать все заявки" + System.lineSeparator()
                        + "1. Завершить программу" + System.lineSeparator()
                        + "=== Вывод всех заявок ===" + System.lineSeparator()
                        + "Хранилище еще не содержит заявок" + System.lineSeparator()
                        + "Меню:" + System.lineSeparator()
                        + "0. Показать все заявки" + System.lineSeparator()
                        + "1. Завершить программу" + System.lineSeparator()
                        + "=== Завершение программы ===" + System.lineSeparator()
        );
    }

    @Test
    void whenSomeItemsFindByName1From3Successfully() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item one = tracker.add(new Item("Item1"));
        tracker.add(new Item("Item2"));
        tracker.add(new Item("Item3"));
        String foundName = "Item1";
        Input input = new MockInput(
                new String[]{"0", foundName, "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new FindByNameAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString()).isEqualTo(
                "Меню:" + System.lineSeparator()
                        + "0. Показать заявки по имени" + System.lineSeparator()
                        + "1. Завершить программу" + System.lineSeparator()
                        + "=== Вывод заявок по имени ===" + System.lineSeparator()
                        + one + System.lineSeparator()
                        + "Меню:" + System.lineSeparator()
                        + "0. Показать заявки по имени" + System.lineSeparator()
                        + "1. Завершить программу" + System.lineSeparator()
                        + "=== Завершение программы ===" + System.lineSeparator()
        );
    }

    @Test
    void whenSomeItemsFindByName2From3Successfully() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item one  = tracker.add(new Item("Item1"));
        tracker.add(new Item("Item2"));
        Item two  = tracker.add(new Item("Item1"));
        String foundName = "Item1";
        Input input = new MockInput(
                new String[]{"0", foundName, "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new FindByNameAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString()).isEqualTo(
                "Меню:" + System.lineSeparator()
                        + "0. Показать заявки по имени" + System.lineSeparator()
                        + "1. Завершить программу" + System.lineSeparator()
                        + "=== Вывод заявок по имени ===" + System.lineSeparator()
                        + one + System.lineSeparator()
                        + two + System.lineSeparator()
                        + "Меню:" + System.lineSeparator()
                        + "0. Показать заявки по имени" + System.lineSeparator()
                        + "1. Завершить программу" + System.lineSeparator()
                        + "=== Завершение программы ===" + System.lineSeparator()
        );
    }

    @Test
    void whenSomeItemsFindByNameNotSuccessfully() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Item1"));
        tracker.add(new Item("Item2"));
        tracker.add(new Item("Item1"));
        String foundName = "ItemNotSuch";
        Input input = new MockInput(
                new String[]{"0", foundName, "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new FindByNameAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString()).isEqualTo(
                "Меню:" + System.lineSeparator()
                        + "0. Показать заявки по имени" + System.lineSeparator()
                        + "1. Завершить программу" + System.lineSeparator()
                        + "=== Вывод заявок по имени ===" + System.lineSeparator()
                        + "Заявки с именем: " + foundName + " не найдены." + System.lineSeparator()
                        + "Меню:" + System.lineSeparator()
                        + "0. Показать заявки по имени" + System.lineSeparator()
                        + "1. Завершить программу" + System.lineSeparator()
                        + "=== Завершение программы ===" + System.lineSeparator()
        );
    }

    @Test
    void whenNotItemsFindByName() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        String foundName = "Item1";
        Input input = new MockInput(
                new String[]{"0", foundName, "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new FindByNameAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString()).isEqualTo(
                "Меню:" + System.lineSeparator()
                        + "0. Показать заявки по имени" + System.lineSeparator()
                        + "1. Завершить программу" + System.lineSeparator()
                        + "=== Вывод заявок по имени ===" + System.lineSeparator()
                        + "Заявки с именем: " + foundName + " не найдены." + System.lineSeparator()
                        + "Меню:" + System.lineSeparator()
                        + "0. Показать заявки по имени" + System.lineSeparator()
                        + "1. Завершить программу" + System.lineSeparator()
                        + "=== Завершение программы ===" + System.lineSeparator()
        );
    }

    @Test
    void whenSomeItemsFindByIdSuccessfully() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item[] items = new Item[3];
        items[0] = tracker.add(new Item("Item1"));
        items[1] = tracker.add(new Item("Item2"));
        items[2] = tracker.add(new Item("Item1"));
        int foundedId = items[1].getId();
        Input input = new MockInput(
                new String[]{"0", String.valueOf(foundedId), "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new FindByIdAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString()).isEqualTo(
                "Меню:" + System.lineSeparator()
                        + "0. Показать заявку по id" + System.lineSeparator()
                        + "1. Завершить программу" + System.lineSeparator()
                        + "=== Вывод заявки по id ===" + System.lineSeparator()
                        + tracker.findById(items[1].getId()).toString() + System.lineSeparator()
                        + "Меню:" + System.lineSeparator()
                        + "0. Показать заявку по id" + System.lineSeparator()
                        + "1. Завершить программу" + System.lineSeparator()
                        + "=== Завершение программы ===" + System.lineSeparator()
        );
    }

    @Test
    void whenSomeItemsFindByIdNotSuccessfully() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item[] items = new Item[3];
        items[0] = tracker.add(new Item("Item1"));
        items[1] = tracker.add(new Item("Item2"));
        items[2] = tracker.add(new Item("Item1"));
        int foundedId = items[1].getId();
        Input input = new MockInput(
                new String[]{"0", String.valueOf(foundedId), "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new FindByIdAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString()).isEqualTo(
                "Меню:" + System.lineSeparator()
                        + "0. Показать заявку по id" + System.lineSeparator()
                        + "1. Завершить программу" + System.lineSeparator()
                        + "=== Вывод заявки по id ===" + System.lineSeparator()
                        + tracker.findById(items[1].getId()).toString() + System.lineSeparator()
                        + "Меню:" + System.lineSeparator()
                        + "0. Показать заявку по id" + System.lineSeparator()
                        + "1. Завершить программу" + System.lineSeparator()
                        + "=== Завершение программы ===" + System.lineSeparator()
        );
    }

    @Test
    void whenNotItemsFindById() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        int foundedId = 1;
        Input input = new MockInput(
                new String[]{"0", String.valueOf(foundedId), "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new FindByIdAction(output));
        actions.add(new ExitAction(output));
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString()).isEqualTo(
                "Меню:" + System.lineSeparator()
                        + "0. Показать заявку по id" + System.lineSeparator()
                        + "1. Завершить программу" + System.lineSeparator()
                        + "=== Вывод заявки по id ===" + System.lineSeparator()
                        + "Заявка с введенным id: " + foundedId + " не найдена." + System.lineSeparator()
                        + "Меню:" + System.lineSeparator()
                        + "0. Показать заявку по id" + System.lineSeparator()
                        + "1. Завершить программу" + System.lineSeparator()
                        + "=== Завершение программы ===" + System.lineSeparator()
        );
    }

    @Test
    void whenInvalidExit() {
        Output output = new StubOutput();
        Input input = new MockInput(
                new String[] {"1", "0"}
        );
        MemTracker tracker = new MemTracker();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction(output));
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Завершить программу" + ln
                        + "Неверный ввод, вы можете выбрать: 0 .. 0" + ln
                        + "Меню:" + ln
                        + "0. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }
}