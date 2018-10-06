package ru.job4j.comparator;

import java.util.Comparator;

/**
 * ListCompare.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 6.10.2018
 */
public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        for (int index = 0; index < left.length(); index++) {
            result = Character.compare(left.charAt(index), right.charAt(index));
            if (result != 0) {
                break;
            }
        }
        if (result == 0 && left.length() != right.length()) {
            result = Integer.compare(left.length(), right.length());
        }
        return result;
    }
}
