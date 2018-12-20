package ru.job4j.list;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 30.09.2018
 * @version 2
 * @since 20.12.2018
 */
public class UserConvertTest {
    @Test
    public void whenListThenReturnHashMap() {
        UserConvert convert = new UserConvert();
        User first = new User("Petr", 1, "Bryansk");
        User second = new User("Valentin", 2, "Moscow");
        User third = new User("Natasha", 3, "Almaty");
        List<User> list = List.of(first, second, third);
        Map<Integer, User> expected = Map.of(
                first.getId(), first,
                second.getId(), second,
                third.getId(), third
        );
        assertThat(convert.process(list), is(expected));
    }
}
