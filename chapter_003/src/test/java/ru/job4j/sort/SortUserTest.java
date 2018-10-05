package ru.job4j.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 5.10.2018
 */
public class SortUserTest {
    @Test
    public void whenTwoUsersWithSameName() {
        SortUser sortUser = new SortUser();
        List<User> users = new ArrayList<>();
        User first = new User("Michle", 30);
        User second = new User("Michle", 20);
        User third = new User("Alex", 25);
        users.add(first);
        users.add(second);
        users.add(third);
        Set<User> result = sortUser.sort(users);
        Set<User> expected = new TreeSet<>();
        expected.add(third);
        expected.add(second);
        expected.add(first);
        assertThat(result, is(expected));
    }

    @Test
    public void whenThreeUsersWithDifferentName() {
        SortUser sortUser = new SortUser();
        List<User> users = new ArrayList<>();
        User first = new User("Peter", 30);
        User second = new User("Michle", 20);
        User third = new User("Alex", 25);
        users.add(first);
        users.add(second);
        users.add(third);
        Set<User> result = sortUser.sort(users);
        Set<User> expected = new TreeSet<>();
        expected.add(third);
        expected.add(second);
        expected.add(first);
        assertThat(result, is(expected));
    }
}
