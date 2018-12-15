package ru.job4j.departments;

import java.util.List;
import java.util.TreeSet;

/**
 * SortDepartments.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 2
 * @since 8.12.2018
 */
public class SortDepartments {

    /**
     * Method addAll
     * @param to - new set
     * @param from - list of elements
     * @return set with these elements
     */
    private TreeSet<String> addAll(TreeSet<String> to, List<String> from) {
        to.addAll(from);
        from.stream().forEach(
                department -> {
                    StringBuilder element = new StringBuilder();
                    for (int index = 0; index < department.length(); index++) {
                        if (department.charAt(index) == '\\') {
                            to.add(element.toString());
                        }
                        element.append(department.charAt(index));
                    }
                });
        return to;
    }

    /**
     * Method sort
     * @param departments - list of departments
     * @param sort - select '0' to sort ascending
     *             - select '1' to sort descending
     * @return sorted list of departments
     */
    public TreeSet<String> sort(List<String> departments, int sort) {
        TreeSet<String> result = new TreeSet<>();
        result.stream().sorted(
                (left, right) -> {
                        int rest = 0;
                        char[] first = left.toCharArray();
                        char[] second = right.toCharArray();
                        for (int index = 0; index < Math.min(first.length, second.length); index++) {
                            if (first[index] != second[index] && sort == 0) {
                                rest = Character.compare(first[index], second[index]);
                                break;
                            } else if (first[index] != second[index] && sort == 1) {
                                rest = Character.compare(second[index], first[index]);
                                break;
                            }
                        }
                        return rest == 0 ? Integer.compare(first.length, second.length) : rest;
                    });
        return this.addAll(result, departments);
    }
}

