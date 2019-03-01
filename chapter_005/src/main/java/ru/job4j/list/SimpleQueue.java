package ru.job4j.list;

/**
 * SimpleQueue.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 1.03.2019
 */
public class SimpleQueue<E> {
    private SimpleStack<E> forStorage = new SimpleStack<>();
    private SimpleStack<E> forExtraction = new SimpleStack<>();

    public SimpleQueue() {
    }

    public void push(E value) {
        forStorage.push(value);
    }

    public E poll() {
        if (forExtraction.isEmpty()) {
            while (!forStorage.isEmpty()) {
                forExtraction.push(forStorage.poll());
            }
        }
        return forExtraction.poll();
    }
}
