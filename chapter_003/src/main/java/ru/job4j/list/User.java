package ru.job4j.list;

/**
 * User.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 30.09.2018
 */
public class User {
    private String name;
    private int id;
    private String city;

    public User(String name, int id, String city) {
        this.name = name;
        this.id = id;
        this.city = city;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public String getCity() {
        return this.city;
    }
}
