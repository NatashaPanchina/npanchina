package ru.job4j.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ConvertList2Array.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 2
 * @since 20.09.2018
 */
public class ConvertList2Array {
    /**
     * Method - convert List to 2Array.
     * @param list - collection.
     * @param rows of the output array.
     * @return two-dimensional array.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size() % rows == 0 ? list.size() / rows : list.size() / rows + 1;
        int[][] array = new int[rows][cells];
        int out = 0;
        int in = 0;
        for (Integer element : list) {
            array[out][in] = element;
            if (in == cells - 1) {
                out++;
                in = 0;
            } else {
                in++;
            }
            if (out == rows) {
                break;
            }
        }
        return array;
    }

    /**
     * Method convert.
     * @param list - collection.
     * @return convert list.
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        list.stream().map(Arrays::stream).forEach(elements -> elements.forEach(result::add));
        return result;
    }
}
