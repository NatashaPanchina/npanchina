package ru.job4j.array;

import java.util.Arrays;

/**
 * ArrayDuplicate.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ArrayDuplicate {
    /**
     * Method remove Duplicates.
     * @param array - input array
     * @return array without duplicates.
     */
    public String[] remove(String[] array) {
        int size = array.length;
        for (int out = 0; out < size; out++) {
            for (int in = out + 1; in < size; in++) {
                if (array[out].equals(array[in])) {
                    array[in] = array[size - 1];
                    size--;
                    in--;
                }
            }
        }
        return Arrays.copyOf(array, size);
    }
}
