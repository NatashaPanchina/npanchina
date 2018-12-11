package ru.job4j.tracker;

/**
 * StartUI.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 2
 * @since 0.1
 */
public class StartUI {
    private boolean exit = true;

    private final Input input;

    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void stopProgram() {
        this.exit = false;
    }

    public void init() {
        int key;
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions(this);
        do {
            menu.show(System.out::println);
            key = this.input.ask("Выберите пункт меню: ", menu.getRanges());
            menu.select(key);
        } while (this.exit);
    }

    public static void main(String[] args) {
        new StartUI(
                new ValidateInput(
                        new ConsoleInput()
                ),
                new Tracker()
        ).init();
    }
}
