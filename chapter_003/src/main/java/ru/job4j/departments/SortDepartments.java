package ru.job4j.departments;

import java.util.Comparator;
import java.util.List;

/**
 * SortDepartments.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 8.12.2018
 */
public class SortDepartments {
    /**
     * Method sort
     * @param departments - list of departments
     * @param sort - select '0' to sort ascending
     *             - select '1' to sort descending
     * @return sorted list of departments
     */
    public List<String> sort(List<String> departments, int sort) {
        List<String> list = departments;
        list.sort(
                new Comparator<String>() {
                    @Override
                    public int compare(String left, String right) {
                        int result = 0;
                        char[] first = left.toCharArray();
                        char[] second = right.toCharArray();
                        for (int index = 0; index < Math.min(first.length, second.length); index++) {
                            if (first[index] != second[index] && sort == 0) {
                                result = Character.compare(first[index], second[index]);
                                break;
                            } else if (first[index] != second[index] && sort == 1) {
                                result = Character.compare(second[index], first[index]);
                                break;
                            }
                        }
                        return result == 0 ? Integer.compare(first.length, second.length) : result;
                    }
                });
        return list;
    }
}

