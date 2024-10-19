package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель данных Пользователь
 * @author Olga Ilyina
 * @version 1.0
 */
public class User {
    /**
     * Поле содержит номер паспорта
     */
    private String passport;

    /**
     * Поле содержит имя пользователя
     */
    private String username;

    /**
     * Конструктор по созданию пользователя
     * @param passport номер паспорта пользователя
     * @param username имя пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод получения номера паспорта пользователя
     * @return возвращает номер паспорта
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод изменения номера паспорта пользователя
     * @param passport номер паспорта пользователя
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод получения имени пользователя
     * @return возвращает имя пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод изменения имени пользователя
     * @param username имя пользователя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
