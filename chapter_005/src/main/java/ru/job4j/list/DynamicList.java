package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * DynamicList.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 26.02.2019
 */
public class DynamicList<E> implements Iterable<E> {
    private Object[] container;
    private int size = 10;
    private int position = 0;
    private int modCount = 0;

    public DynamicList() {
        container = new Object[this.size];
    }

    public DynamicList(int size) {
        if (size > 0) {
            this.size = size;
        }
        container = new Object[this.size];
    }

    public void add(E value) {
        modCount++;
        if (this.position == this.size) {
            this.grow();
        }
        this.container[position++] = value;
    }

    public E get(int index) {
        E result = null;
        if (index < this.position) {
            result = (E) this.container[index];
        }
        return result;
    }

    public int length() {
        return this.size;
    }

    /**
     * Method - increase array
     */
    private void grow() {
        this.size = this.size * 2;
        Object[] newContainer = new Object[this.size];
        System.arraycopy(this.container, 0, newContainer, 0, this.container.length);
        this.container = newContainer;
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int count = 0;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                checkModification();
                return count < position;
            }

            @Override
            public E next() {
                checkModification();
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) container[count++];
            }

            private void checkModification() {
                if (this.expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }
}
