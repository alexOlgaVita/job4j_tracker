package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {
    @Test
    void whenCreateItem() {
        Output output = new StubOutput();
        Input input = new MockInput(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("Item name");
    }

    @Test
    void whenReplaceItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input input = new MockInput(
                new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo(replacedName);
    }

    @Test
    void whenDeleteItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input input = new MockInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    void whenExit() {
        Output output = new StubOutput();
        Input input = new MockInput(
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(output)
        };
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
        Tracker tracker = new Tracker();
        Item[] items = new Item[4];
        for (int i = 0; i < 4; i++) {
            items[i] = tracker.add(new Item("Item" + i));
        }
        Input input = new MockInput(
                new String[]{"0", "1"}
        );
        UserAction[] actions = {
                new FindAllAction(output),
                new ExitAction(output)
        };
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
        Tracker tracker = new Tracker();
        Input input = new MockInput(
                new String[]{"0", "1"}
        );
        UserAction[] actions = {
                new FindAllAction(output),
                new ExitAction(output)
        };
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
    void whenSomeItemsFindByNameSuccessfully() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item[] items = new Item[3];
        items[0] = tracker.add(new Item("Item1"));
        items[1] = tracker.add(new Item("Item2"));
        items[2] = tracker.add(new Item("Item1"));
        String foundName = "Item1";
        Input input = new MockInput(
                new String[]{"0", foundName, "1"}
        );
        UserAction[] actions = {
                new FindByNameAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        StringBuilder allItemsPrint = new StringBuilder();
        allItemsPrint.append(tracker.findById(items[0].getId()).toString()).append(System.lineSeparator());
        allItemsPrint.append(tracker.findById(items[2].getId()).toString()).append(System.lineSeparator());
        assertThat(output.toString()).isEqualTo(
                "Меню:" + System.lineSeparator()
                        + "0. Показать заявки по имени" + System.lineSeparator()
                        + "1. Завершить программу" + System.lineSeparator()
                        + "=== Вывод заявок по имени ===" + System.lineSeparator()
                        + allItemsPrint
                        + "Меню:" + System.lineSeparator()
                        + "0. Показать заявки по имени" + System.lineSeparator()
                        + "1. Завершить программу" + System.lineSeparator()
                        + "=== Завершение программы ===" + System.lineSeparator()
        );
    }

    @Test
    void whenSomeItemsFindByNameNotSuccessfully() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Item("Item1"));
        tracker.add(new Item("Item2"));
        tracker.add(new Item("Item1"));
        String foundName = "ItemNotSuch";
        Input input = new MockInput(
                new String[]{"0", foundName, "1"}
        );
        UserAction[] actions = {
                new FindByNameAction(output),
                new ExitAction(output)
        };
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
        Tracker tracker = new Tracker();
        String foundName = "Item1";
        Input input = new MockInput(
                new String[]{"0", foundName, "1"}
        );
        UserAction[] actions = {
                new FindByNameAction(output),
                new ExitAction(output)
        };
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
        Tracker tracker = new Tracker();
        Item[] items = new Item[3];
        items[0] = tracker.add(new Item("Item1"));
        items[1] = tracker.add(new Item("Item2"));
        items[2] = tracker.add(new Item("Item1"));
        int foundedId = items[1].getId();
        Input input = new MockInput(
                new String[]{"0", String.valueOf(foundedId), "1"}
        );
        UserAction[] actions = {
                new FindByIdAction(output),
                new ExitAction(output)
        };
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
        Tracker tracker = new Tracker();
        Item[] items = new Item[3];
        items[0] = tracker.add(new Item("Item1"));
        items[1] = tracker.add(new Item("Item2"));
        items[2] = tracker.add(new Item("Item1"));
        int foundedId = items[1].getId();
        Input input = new MockInput(
                new String[]{"0", String.valueOf(foundedId), "1"}
        );
        UserAction[] actions = {
                new FindByIdAction(output),
                new ExitAction(output)
        };
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
        Tracker tracker = new Tracker();
        int foundedId = 1;
        Input input = new MockInput(
                new String[]{"0", String.valueOf(foundedId), "1"}
        );
        UserAction[] actions = {
                new FindByIdAction(output),
                new ExitAction(output)
        };
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
}