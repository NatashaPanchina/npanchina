package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 30.09.2018
 */
public class UserConvertTest {
    @Test
    public void whenListThenReturnHashMap() {
        UserConvert convert = new UserConvert();
        List<User> list = new ArrayList<>();
        User first = new User("Petr", 1, "Bryansk");
        User second = new User("Valentin", 2, "Moscow");
        User third = new User("Natasha", 3, "Almaty");
        list.add(first);
        list.add(second);
        list.add(third);
        HashMap<Integer, User> expected = new HashMap<>();
        expected.put(first.getId(), first);
        expected.put(second.getId(), second);
        expected.put(third.getId(), third);
        HashMap<Integer, User> result = convert.process(list);
        assertThat(result, is(expected));
    }
}
