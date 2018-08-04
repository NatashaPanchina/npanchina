package ru.job4j.tracker;

/**
 * StartUI.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    private static boolean exit = true;

    private int[] ranges = {0, 1, 2, 3, 4, 5, 6};
    private final Input input;

    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public static void stopProgram() {
        exit = false;
    }

    public void init() {
        int key;
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        do {
            menu.show();
            key = this.input.ask("Выберите пункт меню: ", ranges);
            menu.select(key);
        } while (exit);
    }

    public static void main(String[] args) {
        new StartUI(new ValidateInput(), new Tracker()).init();
    }
}
