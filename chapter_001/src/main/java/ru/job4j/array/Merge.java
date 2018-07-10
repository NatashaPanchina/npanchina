package ru.job4j.array;

/**
 * Merge.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Merge {
    /**
     * Method arraysMerge.
     * @param array - first sorted array
     * @param array2 - second sorted array
     * @return sorted arrays merge.
     */
    public int[] arraysMerge(int[] array, int[] array2) {
        int j = 0, i = 0, index = 0;
        int[] arrayresult = new int[array.length + array2.length];
        while (j < array.length && i < array2.length) {
            if (array[j] < array2[i]) {
                arrayresult[index] = array[j];
                j++;
            } else {
                arrayresult[index] = array2[i];
                i++;
            }
            index++;
        }
        while (j < array.length) {
            arrayresult[index] = array[j];
            j++;
            index++;
        }
        while (i < array2.length) {
            arrayresult[index] = array2[i];
            i++;
            index++;
        }
        return arrayresult;
    }
}
