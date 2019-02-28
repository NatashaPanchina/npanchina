package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * DynamicLinkedList.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 28.02.2019
 */
public class DynamicLinkedList<E> implements Iterable<E> {
    private int size = 0;
    private Node<E> first;
    private Node<E> last;
    private int modCount = 0;

    public DynamicLinkedList() {
    }

    public void add(E value) {
        Node<E> end = this.last;
        Node<E> newNode = new Node<>(value);
        this.last = newNode;
        if (end == null) {
            this.first = newNode;
        } else {
            end.next = newNode;
            newNode.prev = end;
        }
        size++;
        modCount++;
    }

    public E get(int index) {
        E result = null;
        Node<E> node = this.first;
        if (node != null) {
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            result = node.date;

        }
        return result;
    }

    public int size() {
        return this.size;
    }

    public Iterator<E> iterator() {
        return new Iterator<>() {
            private int count = 0;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                checkModification();
                return count < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return get(count++);
            }

            private void checkModification() {
                if (this.expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }

    private static class Node<E> {
        E date;
        Node<E> next;
        Node<E> prev;

        Node(E date) {
            this.date = date;
        }
    }
}
