package ru.job4j.map;

import java.util.Calendar;

/**
 * User.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 4
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

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof User)) {
            return false;
        }
        User user = (User) other;
        return (this.children == user.children)
                && (this.name == null ? user.name == null
                    : this.name.equals(user.name))
                && (this.birthday == null ? user.birthday == null
                    : this.birthday.equals(user.birthday));
    }
}
