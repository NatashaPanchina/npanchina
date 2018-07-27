package ru.job4j.tracker;

/**
 * StartUI.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    private static final String ADD = "0";
    private static final String SHOW = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FIND_BY_ID = "4";
    private static final String FIND_BY_NAME = "5";
    private static final String EXIT = "6";

    private static boolean exit = true;

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
            String answer = this.input.ask("Выберите пункт меню: ");
            if (ADD.equals(answer)) {
                key = Integer.valueOf(answer);
                menu.select(key);
            } else if (SHOW.equals(answer)) {
                key = Integer.valueOf(answer);
                menu.select(key);
            } else if (EDIT.equals(answer)) {
                key = Integer.valueOf(answer);
                menu.select(key);
            } else if (DELETE.equals(answer)) {
                key = Integer.valueOf(answer);
                menu.select(key);
            } else if (FIND_BY_ID.equals(answer)) {
                key = Integer.valueOf(answer);
                menu.select(key);
            } else if (FIND_BY_NAME.equals(answer)) {
                key = Integer.valueOf(answer);
                menu.select(key);
            } else if (EXIT.equals(answer)) {
                key = Integer.valueOf(answer);
                menu.select(key);
            }
        } while (exit);
    }

    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
