package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * SimpleArray.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 14.02.2019
 */
public class SimpleArray<T> implements Iterable<T> {
    private T[] array;
    private int size;
    private int index = 0;

    public SimpleArray(int size) {
        if (size > 0) {
            this.array = (T[]) new Object[size];
            this.size = size;
        } else {
            throw new IllegalArgumentException("Illegal size");
        }
    }

    public void add(T model) {
        if (this.index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        this.array[this.index++] = model;
    }

    public void set(int index, T model) {
        if (index < this.size) {
            this.array[index] = model;
        }
    }

    public void remove(int index) {
        for (; index < this.size - 1; index++) {
            this.array[index] = this.array[index + 1];
        }
        this.size--;
    }

    public T get(int index) {
        T result = null;
        if (index < this.size) {
            result = this.array[index];
        }
        return result;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int count = 0;
            @Override
            public boolean hasNext() {
                return count < size;
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
