package ru.job4j.list;

import java.util.List;
import java.util.HashMap;

/**
 * User Convert.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 30.09.2018
 */
public class UserConvert {
    /**
     * Method process.
     * @param list - collection.
     * @return HashMap collection.
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<>();
        for (User user : list) {
            result.put(user.getId(), user);
        }
        return result;
    }
}
