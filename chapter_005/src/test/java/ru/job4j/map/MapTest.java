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
 * @version 2
 * @since 17.06.2019
 */
public class MapTest {

    /*
    В хеш-таблице все еще будут храниться  два объекта.
    Потому что после удачной проверки хеш-кодов объектов на равенство,
    для них вызовется метод equals() из класса Object.
    Эта версия equals() сравнивает не поля, а адреса объектов, она вернет
    false и второй объект добавится в таблицу.
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
