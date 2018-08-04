package ru.job4j.tracker;

public class ValidateInput extends ConsoleInput {
    @Override
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
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
