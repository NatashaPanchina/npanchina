package ru.job4j.sort;

import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 2
 * @since 5.10.2018
 * @version 3
 * @since 20.12.2018
 */
public class SortUserTest {

    SortUser sortUser = new SortUser();

    User first = new User("Michle", 30);
    User second = new User("Michle", 20);
    User third = new User("Alex", 25);

    List<User>  users = List.of(first, second, third);;

    @Test
    public void whenTwoUsersWithSameName() {
        Set<User> expected = Set.of(second, first, third);
        assertThat(sortUser.sort(users), is(expected));
    }

    @Test
    public void whenTwoUsersWithSameNameThenSortByAllFields() {
        List<User> expected = List.of(third, second, first);
        assertThat(sortUser.sortByAllFields(users), is(expected));
    }

    @Test
    public void whenThreeUsersThenReturnSortedListByNameLength() {
        List<User> expected = List.of(third, first, second);
        assertThat(sortUser.sortNameLength(users), is(expected));
    }
}
