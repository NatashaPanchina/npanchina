package ru.job4j.array;

/**
 * BubbleSort.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class BubbleSort {
    /**
     * Method sort.
     * @param array - массив целых чисел
     * @return - отсортированный массив целых чисел
     */
    public int[] sort(int[] array) {
        int temp = 0;
        for (int count = 0; count < array.length - 1; count++) {
            for (int index = 0; index < array.length - 1; index++) {
                if (array[index] > array[index + 1]) {
                    temp = array[index + 1];
                    array[index + 1] = array[index];
                    array[index] = temp;
                }
            }
        }
        return array;
    }
}
