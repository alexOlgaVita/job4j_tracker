package ru.job4j.pojo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Olga Ilyina");
        student.setGroup(1);
        student.setReceiptDate(LocalDate.now().minusDays(6));
        LocalDate receiptDate = student.getReceiptDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String receiptDateFormat = receiptDate.format(formatter);
        System.out.println(student.getFio() + " учится в группе #" + student.getGroup() + ", дата поступления: " + receiptDateFormat);
    }
}
