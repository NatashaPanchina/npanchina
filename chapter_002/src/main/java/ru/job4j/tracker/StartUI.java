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

    private final Input input;

    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню: ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW.equals(answer)) {
                this.showItems();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FIND_BY_ID.equals(answer)) {
                this.findItemById();
            } else if (FIND_BY_NAME.equals(answer)) {
                this.findItemsByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    private void createItem() {
        System.out.println("------------ Добавление новой заявки ------------");
        String name = this.input.ask("Введите имя заявки: ");
        String desc = this.input.ask("Введите описание заявки: ");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("Новая заявка: " + item.toString());
    }

    private void showItems() {
        System.out.println("------------ Все заявки ------------");
        for (Item item: this.tracker.getAll()) {
            System.out.println(item.toString());
        }
    }

    private void editItem() {
        System.out.println("------------ Редактирование заявки ------------");
        String id = this.input.ask("Введите ID заявки, которую хотите заменить на новую заявку: ");
        String next = this.input.ask("Введите имя новой заявки: ");
        String desc = this.input.ask("Введите описание новой заявки: ");
        Item item = new Item(next, desc);
        if (this.tracker.replace(id, item)) {
            System.out.println("Замена прошла успешно!\nВаша новая заявка: " + item.toString());
        } else {
            System.out.println("Заявка с указанным ID не найдена.");
        }
    }

    private void deleteItem() {
        System.out.println("------------ Удаление заявки ------------");
        String id = this.input.ask("Введите ID заявки: ");
        if (this.tracker.delete(id)) {
            System.out.println("Удаление прошло успешно!");
        } else {
            System.out.println("Заявка с указанным ID не найдена.");
        }
    }

    private void findItemById() {
        System.out.println("------------ Поиск заявки по ID ------------");
        String id = this.input.ask("Введите ID заявки: ");
        Item item = this.tracker.findById(id);
        if (item != null) {
            System.out.println("Искомая заявка: " + item.toString());
        } else {
            System.out.println("Заявка с указанным ID не найдена.");
        }
    }

    private void findItemsByName() {
        System.out.println("------------ Поиск заявок ------------");
        String name = this.input.ask("Введите имя заявки: ");
        System.out.println("------------ Заявки с указанным именем ------------");
        Item[] result = this.tracker.findByName(name);
        if (result.length != 0) {
            for (Item item : result) {
                System.out.println("Заявка: " + item.toString());
            }
        } else {
            System.out.println("Заявки с именем " + name + " не найдены.");
        }
    }

    private void showMenu() {
        System.out.println("Меню:");
        System.out.println("0. Добавить новую заявку.");
        System.out.println("1. Отобразить список всех заявок.");
        System.out.println("2. Редактировать заявку.");
        System.out.println("3. Удалить заявку.");
        System.out.println("4. Найти заявку по ID.");
        System.out.println("5. Найти заявки совпадающие по имени.");
        System.out.println("6. Выйти из программы.");
    }

    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
