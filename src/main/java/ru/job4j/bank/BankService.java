package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает сервис по работе с банковскими пользователями, их счетами и переводами денег между счетами
 * @author Olga Ilyina
 * @version 1.0
 */
public class BankService {
    /**
     * Поле содержит всех пользователей системы с привязанными к ним счетами
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя в систему, если такого пользователя еще нет.
     * @param user пользователь, которого нужно добавить. По умолчанию к этому user добавляется пустой список счетов.
     */
    public void addUser(User user) {

        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод удаляет пользователя из системы.
     * @param passport паспорт пользователя, удаляемого из системы
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Метод добавляет новый счет к пользователю.
     * @param passport номер паспорта пользователя
     * @param account счет пользователя
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = getAccounts(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по номеру паспорта
     * @param passport номер паспорта
     * @return возвращает пользователя или null, если пользователь не найден
     */
    public User findByPassport(String passport) {
        User result = null;
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                result = user;
                break;
            }
        }
        return result;
    }

    /**
     * Метод ищет счет пользователя по реквизитам
     * @param passport номер паспорта пользователя
     * @param requisite реквизиты счета
     * @return возвращает счет пользователя
     */
    public Account findByRequisite(String passport, String requisite) {
        Account result = null;
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (requisite.equals(account.getRequisite())) {
                    result = account;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Метод перечисляет деньги с одного счёта на другой счёт
     * @param sourcePassport номер паспорта пользователя, со счета которого нужно перевести деньги
     * @param sourceRequisite реквизиты счета пользователя, с которого нужно перевести деньги
     * @param destinationPassport номер паспорта пользователя, на счет которого нужно перевести деньги
     * @param destinationRequisite реквизиты счета пользователя, на который нужно перевести деньги
     * @param amount сумма, которую надо перевести со счета на счет
     * @return возвращает Истина, если перевод был произведен, иначе Ложь
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        Account accountSource = findByRequisite(sourcePassport, sourceRequisite);
        Account destinationSource = findByRequisite(destinationPassport, destinationRequisite);
        if (accountSource != null && destinationSource != null) {
            if (accountSource.getBalance() >= amount) {
                accountSource.setBalance(accountSource.getBalance() - amount);
                destinationSource.setBalance(destinationSource.getBalance() + amount);
                result = true;
            }
        }
        return result;
    }

    /**
     * Метод получения счетов пользователя
     * @param user пользователь
     * @return возвращает список счетов
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
