package ru.job4j.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ConvertMatrix2List.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 2
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
        Arrays.stream(array).forEach(elements -> Arrays.stream(elements).forEach(list::add));
        return list;
    }
}
