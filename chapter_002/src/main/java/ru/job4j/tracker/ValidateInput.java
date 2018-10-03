package ru.job4j.tracker;

import java.util.ArrayList;

public class ValidateInput implements Input {

    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    public int ask(String question, ArrayList<Integer> range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
                invalid = false;
            } catch (MenuOutException exc) {
                System.out.println("Пожалуйста, повторно введите значение из диапазона меню.");
            } catch (NumberFormatException exc) {
                System.out.println("Пожалуйста, попробуйте снова.");
            }
        } while (invalid);
        return value;
    }
}
