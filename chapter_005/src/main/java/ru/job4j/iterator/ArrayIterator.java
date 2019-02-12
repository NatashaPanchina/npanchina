package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * ArrayIterator.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 12.02.2019
 */
public class ArrayIterator<T> implements Iterator<T> {
    private final T[][] values;
    private int in = 0;
    private int out = 0;

    public ArrayIterator(final T[][] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return out < values.length;
    }

    @Override
    public T next() {
        T result;
        if (out > values.length - 1) {
            throw new NoSuchElementException();
        }
        result = values[out][in++];
        if (in == values[out].length) {
            out++;
            in = 0;
        }
        return result;
    }
}
