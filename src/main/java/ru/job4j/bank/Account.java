package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель данных Счет
 * @author Olga Ilyina
 * @version 1.0
 */
public class Account {
    /**
     * Поле содержит реквизиты счета
     */
    private String requisite;

    /**
     * Поле содержит баланс счета
     */
    private double balance;

    /**
     * Конструктор по созданию объекта Счет
     * @param requisite реквизиты счета
     * @param balance баланс счета
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод получения реквизитов счета
     * @return возвращает реквизиты счеты
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод изменения реквизитов счета
     * @param requisite реквизиты счета
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод получения баланса счета
     * @return возвращает баланс счета
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод изменения баланса счета
     * @param balance сумма на балансе счета
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
