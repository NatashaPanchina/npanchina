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
     * @param first - first sorted array
     * @param second - second sorted array
     * @return sorted arrays merge.
     */
    public int[] arraysMerge(int[] first, int[] second) {
        int j = 0, i = 0, index = 0;
        int[] result = new int[first.length + second.length];
        while (j < first.length && i < second.length) {
            if (first[j] < second[i]) {
                result[index] = first[j];
                j++;
            } else {
                result[index] = second[i];
                i++;
            }
            index++;
        }
        while (j < first.length) {
            result[index] = first[j];
            j++;
            index++;
        }
        while (i < second.length) {
            result[index] = second[i];
            i++;
            index++;
        }
        return result;
    }
}
