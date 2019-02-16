package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * SimpleArray.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 2
 * @since 14.02.2019
 */
public class SimpleArray<T> implements Iterable<T> {
    private T[] array;
    private int size = 10;
    private int position = 0;

    public SimpleArray(int size) {
        if (size > 0) {
            this.size = size;
        }
        this.array = (T[]) new Object[this.size];
    }

    public void add(T model) {
        if (this.position >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        this.array[this.position++] = model;
    }

    public void set(int index, T model) {
        if (index < this.position) {
            this.array[index] = model;
        }
    }

    public void remove(int index) {
        for (; index < this.position - 1; index++) {
            this.array[index] = this.array[index + 1];
        }
        this.position--;
    }

    public T get(int index) {
        T result = null;
        if (index < this.position) {
            result = this.array[index];
        }
        return result;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int count = 0;
            @Override
            public boolean hasNext() {
                return count < position;
            }

            @Override
            public T next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[count++];
            }
        };
    }
}
