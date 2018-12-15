package ru.job4j.search;

import java.util.LinkedList;
import java.util.stream.Stream;

/**
 * Priority Queue.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 2
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
        Stream<Task> stream = this.tasks.stream().filter(
                target -> task.getPriority() > target.getPriority()
        );
        int index = (int) stream.count();
        this.tasks.add(index, task);
    }

    public Task take() {
        return this.tasks.poll();
    }
}
