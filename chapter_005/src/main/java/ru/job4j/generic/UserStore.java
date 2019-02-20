package ru.job4j.generic;

/**
 * UserStore.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 20.02.2019
 */
public class UserStore extends AbstractStore<User> {
    public UserStore(int size) {
        super(size);
    }
}
