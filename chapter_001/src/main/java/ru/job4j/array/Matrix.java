package ru.job4j.array;

/**
 * Matrix.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Matrix {
    /**
     * Method multiple.
     * @param size - размер таблицы
     * @return - таблица умножения
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int out = 0; out < size; out++) {
            for (int in = 0; in < size; in++) {
                table[out][in] = (out + 1) * (in + 1);
            }
        }
        return table;
    }
}
