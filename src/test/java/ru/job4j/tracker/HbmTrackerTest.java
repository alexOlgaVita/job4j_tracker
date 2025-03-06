package ru.job4j.tracker;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.job4j.toone.Role;
import ru.job4j.toone.User;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class HbmTrackerTest {

    @AfterEach
    public void clearTasksAfter() {
        clearAll();
    }

    @BeforeEach
    public void clearTasksBefore() {
        clearAll();
    }

    private static void clearAll() {
        try (var tracker = new HbmTracker()) {
            var items = tracker.findAll();
            for (var item : items) {
                tracker.delete(item.getId());
            }
        }

        var hbmUser = new HbmUser();
        var users = hbmUser.findAll();
        for (var user : users) {
            hbmUser.delete(user.getId());
        }

        var roleStore = new HbmRole();
        var roles = roleStore.findAll();
        for (var role : roles) {
            roleStore.delete(role.getId());
        }
    }

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            Item result = tracker.findById(item.getId());
            assertThat(result.getName()).isEqualTo(item.getName());
        }
    }

    @Test
    public void whenTestFindById() {
        Store tracker = new HbmTracker();
        Item bug = new Item("Bug");
        Item item = tracker.add(bug);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName()).isEqualTo(item.getName());
    }

    @Test
    public void whenTestFindAll() {
        Store tracker = new HbmTracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        var expectedList = List.of(first, second);
        assertThat(tracker.findAll()).usingRecursiveComparison()
                .ignoringFields("id", "created", "participates").isEqualTo(expectedList);
    }

    @Test
    public void whenTest3SameNamesFindByNameThen3() {
        Store tracker = new HbmTracker();

        Role role = new Role(null, "Admin");
        HbmRole hbmRole = new HbmRole();
        hbmRole.add(role);
        User user1 = new User(null, "user1", role, null);
        HbmUser hbmUser = new HbmUser();
        hbmUser.add(user1);

        User user2 = new User(null, "user2", role, null);
        hbmUser.add(user2);

        User user3 = new User(null, "user3", role, null);
        hbmUser.add(user3);

        List<User> participates1 = List.of(user1, user2);
        List<User> participates2 = List.of(user1, user3);

        Item first = new Item(null, "First", LocalDateTime.now(), participates1);
        Item second = new Item(null, "Second", LocalDateTime.now(), participates2);
        tracker.add(first);
        tracker.add(second);
        Item third = new Item(null, "First", LocalDateTime.now(), participates1);
        tracker.add(third);
        tracker.add(new Item(null, "Second", LocalDateTime.now(), participates2));
        Item fourth = new Item(null, "First", LocalDateTime.now(), participates1);
        tracker.add(fourth);
        var expectedList = List.of(first, first, third, third, fourth, fourth);
        assertThat(tracker.findByName(first.getName())).usingRecursiveComparison()
                .ignoringFields("id", "created", "participates").isEqualTo(expectedList);
    }

    @Test
    public void whenTestNotSameNamesFindByNameThenEmpty() {
        Store tracker = new HbmTracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        Item third = new Item("First");
        tracker.add(third);
        tracker.add(new Item("Second"));
        Item fourth = new Item("First");
        tracker.add(fourth);
        assertThat(tracker.findByName("Million")).usingRecursiveComparison()
                .ignoringFields("id", "created").isEqualTo(List.of());
    }

    @Test
    public void whenReplaceItemIsSuccessful() {
        Store tracker = new HbmTracker();
        Item item = new Item("Bug");
        tracker.add(item);
        int id = item.getId();
        Item updateItem = new Item("Bug with description");
        tracker.replace(id, updateItem);
        assertThat(tracker.findById(id).getName()).isEqualTo("Bug with description");
    }

    @Test
    public void whenReplaceItemIsNotSuccessful() {
        Store tracker = new HbmTracker();
        Item item = new Item("Bug");
        tracker.add(item);
        Item updateItem = new Item("Bug with description");
        boolean result = tracker.replace(1000, updateItem);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo("Bug");
        assertThat(result).isFalse();
    }

    @Test
    public void whenDeleteItemIsSuccessful() {
        Store tracker = new HbmTracker();
        Item item = new Item("Bug");
        tracker.add(item);
        int id = item.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id)).isNull();
    }

    @Test
    public void whenDeleteItemIsNotSuccessful() {
        Store tracker = new HbmTracker();
        Item item = new Item("Bug");
        tracker.add(item);
        tracker.delete(1000);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo("Bug");
    }
}