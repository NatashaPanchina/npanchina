package ru.job4j.list;

/**
 * SimpleStack.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 2
 * @since 1.03.2019
 */
public class SimpleStack<E> {
    DynamicLinkedList<E> dynamicLinkedList = new DynamicLinkedList<>();

    public SimpleStack() {
    }

    public void push(E value) {
        dynamicLinkedList.add(value);
    }

    public E poll() {
        return dynamicLinkedList.removeLast();
    }

    public boolean isEmpty() {
        return dynamicLinkedList.size() <= 0;
    }
}
