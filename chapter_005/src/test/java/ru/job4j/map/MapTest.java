package ru.job4j.map;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Test.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 17.06.2019
 */
public class MapTest {

    /*
    В хеш-таблице будут храниться два объекта.

    При добавлении второго объекта в коллекцию
    проверка методом hashCode дубликаты не обнаружила.
    Как правило, если хеш-коды разные, то и объекты разные,
    и метод equals() вызываться вообще не будет.
    В данном случае используется реализация hashCode(), equals(),
    определенная в классе Object, поэтому не обнаружились одинаковые
    с точки зрения логики объекты и оба добавились в хеш-таблицу.
     */
    @Test
    public void whenHashCodeAndEqualsAreNotOverridden() {
        Calendar date = new GregorianCalendar(2019, 5, 14);
        User first = new User("Alex", 1, date);
        User second = new User("Alex", 1, date);
        Map<User, Integer> map = new HashMap<>();
        map.put(first, 1);
        map.put(second, 1);
        System.out.println(map);
    }
}
