package ru.job4j.map;

import java.util.Calendar;

/**
 * User.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 11.06.2019
 */
public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }
}
