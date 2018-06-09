package ru.job4j.array;

/**
 * Turn.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Turn {
    /**
     * Method back.
     * @param array of numbers
     * @return inverted array
     */
    public int[] back(int[] array) {
        int value;
        for (int index = 0; index < array.length / 2; index++) {
            value = array[array.length - 1 - index];
            array[array.length - 1 - index] = array[index];
            array[index] = value;
        }
        return array;
    }
}
