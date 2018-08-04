package ru.job4j.tracker;
//18 10 //7мин
public interface Input {
    String ask(String question);
    int ask(String question, int[] range);
}
