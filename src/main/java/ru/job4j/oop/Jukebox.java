package ru.job4j.oop;

public class Jukebox {
    public void music(int position) {
        String lyrics = "Песня не найдена";
        switch (position) {
            case 1 -> lyrics = "Пусть бегут неуклюже";
            case 2 -> lyrics = "Спокойной ночи";
            default -> {
            }
        }
        System.out.println(lyrics);
    }

    public static void main(String[] args) {
        Jukebox jukebox = new Jukebox();
        for (int i = 1; i < 10; i++) {
            System.out.print("position #" + i + ": ");
            jukebox.music(i);
        }

    }
}
