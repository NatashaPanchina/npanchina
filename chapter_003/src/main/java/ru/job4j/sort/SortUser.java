package ru.job4j.sort;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        Stream<User> stream = list.stream().sorted(Comparator.comparingInt(user -> user.getName().length()));
        return stream.collect(Collectors.toList());
    }

    /**
     * Method sortByAllFields
     * @param list - collection
     * @return sorted list by all fields
     */
    public List<User> sortByAllFields(List<User> list) {
        Stream<User> stream = list.stream().sorted(Comparator.comparing(User::getName).thenComparing(User::getAge));
        return stream.collect(Collectors.toList());
    }
}
