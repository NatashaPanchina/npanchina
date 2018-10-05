package ru.job4j.sort;

import java.util.*;

/**
 * SortUser.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 2
 * @since 5.10.2018
 */
public class SortUser {
    /**
     * Method sort.
     * @param list - users
     * @return users are sorted by age
     */
    public Set<User> sort(List<User> list) {
        return new TreeSet<User>(list);
    }

    /**
     * Method sortNameLength
     * @param list - collection
     * @return sorted list by names' length
     */
    public List<User> sortNameLength(List<User> list) {
        List<User> result = new ArrayList<>(list);
        result.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User first, User second) {
                        int result = first.getName().length() > second.getName().length() ? 1 : -1;
                        if (first.getName().length() == second.getName().length()) {
                            result = 0;
                        }
                        return result;
                    }
                }
        );
        return result;
    }

    /**
     * Method sortByAllFields
     * @param list - collection
     * @return sorted list by all fields
     */
    public List<User> sortByAllFields(List<User> list) {
        List<User> result = new ArrayList<>(list);
        result.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User first, User second) {
                        int result = first.getName().compareTo(second.getName());
                        if (result == 0) {
                            result = Integer.compare(first.getAge(), second.getAge());
                        }
                        return result;
                    }
                }
        );
        return result;
    }
}
