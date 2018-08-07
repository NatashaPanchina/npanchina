package ru.job4j.tracker;

import java.util.*;

/**
 * Add Item - внешний класс.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version $Id$
 * @since 0.1
 */
class AddItem extends BaseAction {

    AddItem(int key, String info) {
        super(key, info);
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
}

/**
 * Menu Tracker.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class MenuTracker {

    private int[] ranges;

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
    public void fillActions(StartUI ui) {
        this.actions.add(new AddItem(0, "Добавить новую заявку."));
        this.actions.add(new ShowItems(1, "Отобразить список всех заявок."));
        this.actions.add(new MenuTracker.EditItem(2, "Редактировать заявку."));
        this.actions.add(new MenuTracker.DeleteItem(3, "Удалить заявку."));
        this.actions.add(new FindItemById(4, "Найти заявку по ID."));
        this.actions.add(new FindItemsByName(5, "Найти заявки совпадающие по имени."));
        this.actions.add(new ExitProgram(6, "Выйти из программы.", ui));
    }

    /**
     * Возвращает массив ключей.
     */
    public int[] getRanges() {
        this.ranges = new int[this.actions.size()];
        for (int index = 0; index < ranges.length; index++) {
            ranges[index] = this.actions.get(index).key();
        }
        return ranges;
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

    class ShowItems extends BaseAction {

        ShowItems(int key, String info) {
            super(key, info);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Все заявки ------------");
            for (Item item: tracker.getAll()) {
                System.out.println(item.toString());
            }
        }
    }

    static class EditItem extends BaseAction {

        EditItem(int key, String info) {
            super(key, info);
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
    }

    static class DeleteItem extends BaseAction {

        DeleteItem(int key, String info) {
            super(key, info);
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
    }

    class FindItemById extends BaseAction {

        FindItemById(int key, String info) {
            super(key, info);
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
    }

    class FindItemsByName extends BaseAction {

        FindItemsByName(int key, String info) {
            super(key, info);
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
    }


    class ExitProgram extends BaseAction {
        private final StartUI ui;

        ExitProgram(int key, String info, StartUI ui) {
            super(key, info);
            this.ui = ui;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            this.ui.stopProgram();
        }
    }
}
