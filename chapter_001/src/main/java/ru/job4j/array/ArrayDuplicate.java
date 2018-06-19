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
        int counter = 0;
        for (int out = 0; out < array.length - 1; out++) {
            for (int in = out + 1; in < array.length; in++) {
                if (array[out].equals(array[in])) {
                    array[out] = "";
                    counter++;
                    break;
                }
            }
        }
        Arrays.sort(array);
        return Arrays.copyOfRange(array, counter, array.length);
    }
}
