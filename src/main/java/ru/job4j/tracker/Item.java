package ru.job4j.tracker;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import static java.time.LocalDateTime.now;

@Entity
@Table(name = "items")
@Data
public class Item {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private LocalDateTime created = now();

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Item(int id, String name, LocalDateTime created) {
        this.id = id;
        this.name = name;
        this.created = created;
    }

    @Override
    public String toString() {
        return "Item{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", created=" + created.format(FORMATTER)
                + '}';
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 17;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + id;
        result = prime * result + created.truncatedTo(ChronoUnit.MILLIS).hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Item item = (Item) obj;
        return (id == item.id) && (name.equals(item.name))
                && (created.truncatedTo(ChronoUnit.MILLIS).equals(item.created.truncatedTo(ChronoUnit.MILLIS)));
    }
}