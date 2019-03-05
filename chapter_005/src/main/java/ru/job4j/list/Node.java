package ru.job4j.list;

/**
 * Node.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 5.03.2019
 */
public class Node<T> {
    private T value;
    Node<T> next;

    public Node(T value) {
        this.value = value;
    }

}
