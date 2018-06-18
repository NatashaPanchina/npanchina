package ru.job4j.array;

/**
 * MatrixCheck.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class MatrixCheck {
    /**
     * Method mono.
     * @param data - массив
     * @return результат сравнения значений по диагоналям.
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int index = 0; index < data.length - 1; index++) {
            if (data[index][index] != data[index + 1][index + 1]) {
               result = false;
               return result;
            }
        }
        for (int index = 0; index < data.length - 1; index++) {
            if (data[index][data.length - index - 1] != data[index + 1] [data.length - index - 2]) {
                result = false;
                return result;
            }
        }
        return result;
    }
}
