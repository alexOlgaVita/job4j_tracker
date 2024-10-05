package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {

    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Ошибка воспроизводится: " + ((active) ? "Да" : "Нет"));
        System.out.println("Статус ошибки: " + status);
        System.out.println("Текст ошибки: " + message);
    }

    public static void main(String[] args) {
        Error error1 = new Error();
        error1.printInfo();
        Error error2 = new Error(true, 1, "Недостаточно данных для расчета");
        error2.printInfo();
        Error error3 = new Error(false, 2, "Кнопка сохранения недоступна");
        error3.printInfo();
    }
}
