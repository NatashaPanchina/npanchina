package ru.job4j.search;

import java.util.LinkedList;

/**
 * Priority Queue.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 19.09.2018
 */
public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<Task>();

    /**
     * Метод вставляет в нужную позицию элемент.
     * Позиция определяется по полю приоритет.
     * Для вставок используется add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        int index = 0;
        for ( ; index < this.tasks.size(); index++) {
            if (task.getPriority() <
                    this.tasks.get(index).getPriority()) {
                break;
            }
        }
        this.tasks.add(index, task);
    }

    public Task take() {
        return this.tasks.poll();
    }
}
