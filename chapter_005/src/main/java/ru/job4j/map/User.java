package ru.job4j.map;

import java.util.Calendar;

/**
 * User.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 2
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

    @Override
    public int hashCode() {
        int result = 1;
        result = result * 31 + (this.name == null ? 0 : this.name.hashCode());
        result = result * 31 + this.children;
        result = result * 31 + (this.birthday == null ? 0 : this.birthday.hashCode());
        return result;
    }
}
