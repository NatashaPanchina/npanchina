package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * EvenNumbersIterator.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 12.02.2019
 */
public class EvenNumbersIterator implements Iterator<Integer> {
    final int[] numbers;
    private int index = 0;

    public EvenNumbersIterator(final int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        for (; index < this.numbers.length; index++) {
            if (this.numbers[index] % 2 == 0) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public Integer next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        return this.numbers[index++];
    }
}
