package ru.job4j.list;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * User Convert.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 2
 * @since 30.09.2018
 */
public class UserConvert {
    /**
     * Method process.
     * @param list - collection.
     * @return HashMap collection.
     */
    public Map<Integer, User> process(List<User> list) {
        return list.stream().collect(Collectors.toMap(User::getId, user -> user));
    }
}
