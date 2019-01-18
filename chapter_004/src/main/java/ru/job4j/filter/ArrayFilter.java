package ru.job4j.filter;

import java.util.Arrays;

/**
 * ArrayFilter.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 18.01.2019
 */
public class ArrayFilter {
    /**
     * Method filter
     * @param numbers
     * @return sum of numbers' squares
     */
    public int filter(int[] numbers) {
        return Arrays.stream(numbers)
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .reduce(0, (one, two) -> one + two);
    }
}
