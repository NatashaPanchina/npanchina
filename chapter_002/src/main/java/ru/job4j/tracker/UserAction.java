package ru.job4j.tracker;

/**
 * Interface User Action.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public interface UserAction {
    /**
     * Возвращает ключ опции.
     * @return ключ.
     */
    int key();

    /**
     * Основной метод.
     * @param input объект типа Input.
     * @param tracker объект типа Tracker.
     */
    void execute(Input input, Tracker tracker);

    /**
     * Возвращает информацию о данном пункте меню.
     * @return Строка меню.
     */
    String info();
}
