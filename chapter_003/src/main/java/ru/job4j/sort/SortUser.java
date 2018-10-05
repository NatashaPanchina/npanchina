package ru.job4j.sort;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * SortUser.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
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
}
