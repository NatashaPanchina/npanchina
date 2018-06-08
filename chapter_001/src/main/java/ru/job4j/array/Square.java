package ru.job4j.array;

/**
 * Square.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Square {
    /**
     * Method calculate
     * @param bound - array bounds
     * @return array of square numbers
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        int number = 1;
        for (int index = 0; index < bound; index++) {
            rst[index] = number * number;
            number++;
        }
        return rst;
    }
}
