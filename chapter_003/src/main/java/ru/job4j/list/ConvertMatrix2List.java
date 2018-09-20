package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 * ConvertMatrix2List.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 20.09.2018
 */
public class ConvertMatrix2List {
    /**
     * Method - convert matrix to 2List.
     * @param array - matrix.
     * @return List.
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        int index = 0;
        for (int[] out : array) {
            for (int in : out) {
                list.add(index, in);
                index++;
            }
        }
        return list;
    }
}
