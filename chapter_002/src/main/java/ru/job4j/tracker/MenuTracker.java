package ru.job4j.tracker;

import java.util.*;

/**
 * Menu Tracker.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class MenuTracker {
    private Input input;

    private Tracker tracker;

    private List<UserAction> actions = new ArrayList<>();

    /**
     * Конструктор.
     * @param input объект типа Input.
     * @param tracker объект типа Tracker.
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        this.actions.add(new AddItem(0, "Добавление заявки"));
        this.actions.add(new ShowItems(1, "Показать все заявки"));
        this.actions.add(new MenuTracker.EditItem(2, "Редактировать заявку"));
        this.actions.add(new MenuTracker.DeleteItem(3, "Удаление заявки"));
        this.actions.add(new FindItemById(4, "Поиск заявки по ID"));
        this.actions.add(new FindItemsByName(5, "Поиск заявок по имени"));
        this.actions.add(new ExitProgram(6, "Выход из программы"));
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соответствующее действие.
     *
     * @param key ключ операции.
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Выводит на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    class AddItem implements UserAction {
        private int key;
        private String info;

        AddItem(int key, String info) {
            this.key = key;
            this.info = info;
        }

        @Override
        public int key() {
            return this.key;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки ------------");
            String name = input.ask("Введите имя заявки: ");
            String desc = input.ask("Введите описание заявки: ");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("Новая заявка: " + item.toString());
        }

        @Override
        public String info() {
            return this.key + " " + this.info;
        }
    }

    class ShowItems implements UserAction {
        private int key;
        private String info;

        ShowItems(int key, String info) {
            this.key = key;
            this.info = info;
        }

        @Override
        public int key() {
            return this.key;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Все заявки ------------");
            for (Item item: tracker.getAll()) {
                System.out.println(item.toString());
            }
        }

        @Override
        public String info() {
            return this.key + " " + this.info;
        }
    }

    static class EditItem implements UserAction {
        private int key;
        private String info;

        EditItem(int key, String info) {
            this.key = key;
            this.info = info;
        }

        @Override
        public int key() {
            return this.key;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Редактирование заявки ------------");
            String id = input.ask("Введите ID заявки, которую хотите заменить на новую заявку: ");
            String next = input.ask("Введите имя новой заявки: ");
            String desc = input.ask("Введите описание новой заявки: ");
            Item item = new Item(next, desc);
            if (tracker.replace(id, item)) {
                System.out.println("Замена прошла успешно!\nВаша новая заявка: " + item.toString());
            } else {
                System.out.println("Заявка с указанным ID не найдена.");
            }
        }

        @Override
        public String info() {
            return this.key + " " + this.info;
        }
    }

    static class DeleteItem implements UserAction {
        private int key;
        private String info;

        DeleteItem(int key, String info) {
            this.key = key;
            this.info = info;
        }

        @Override
        public int key() {
            return this.key;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Удаление заявки ------------");
            String id = input.ask("Введите ID заявки: ");
            if (tracker.delete(id)) {
                System.out.println("Удаление прошло успешно!");
            } else {
                System.out.println("Заявка с указанным ID не найдена.");
            }
        }

        @Override
        public String info() {
            return this.key + " " + this.info;
        }
    }

    class FindItemById implements UserAction {
        private int key;
        private String info;

        FindItemById(int key, String info) {
            this.key = key;
            this.info = info;
        }

        @Override
        public int key() {
            return this.key;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по ID ------------");
            String id = input.ask("Введите ID заявки: ");
            Item item = tracker.findById(id);
            if (item != null) {
                System.out.println("Искомая заявка: " + item.toString());
            } else {
                System.out.println("Заявка с указанным ID не найдена.");
            }
        }

        @Override
        public String info() {
            return this.key + " " + this.info;
        }
    }

    class FindItemsByName implements UserAction {
        private int key;
        private String info;

        FindItemsByName(int key, String info) {
            this.key = key;
            this.info = info;
        }

        @Override
        public int key() {
            return this.key;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявок ------------");
            String name = input.ask("Введите имя заявки: ");
            System.out.println("------------ Заявки с указанным именем ------------");
            Item[] result = tracker.findByName(name);
            if (result.length != 0) {
                for (Item item : result) {
                    System.out.println("Заявка: " + item.toString());
                }
            } else {
                System.out.println("Заявки с именем " + name + " не найдены.");
            }
        }

        @Override
        public String info() {
            return this.key + " " + this.info;
        }
    }


    class ExitProgram implements UserAction {
        private int key;
        private String info;

        ExitProgram(int key, String info) {
            this.key = key;
            this.info = info;
        }

        @Override
        public int key() {
            return this.key;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
        }

        @Override
        public String info() {
            return this.key + " " + this.info;
        }
    }
}
