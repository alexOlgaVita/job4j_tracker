package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        int answer = new Random().nextInt(3);
        String name = input.nextLine();
        String answerText;
        if (answer == 0) {
            answerText = "Да";
        } else if (answer == 1) {
            answerText = "Нет";

        } else {
            answerText = "Может быть";
        }
        System.out.println(answerText);
    }
}
