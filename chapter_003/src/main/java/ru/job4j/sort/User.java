package ru.job4j.sort;

/**
 * User.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 5.10.2018
 */
public class User implements Comparable<User> {
    private String name;
    private int age;

    User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public int compareTo(User user) {
        int result = this.getName().compareTo(user.getName());
        if (result == 0) {
            result = Integer.compare(this.getAge(), user.getAge());
        }
        return result;
    }
}
