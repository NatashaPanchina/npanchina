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
 * @version 4
 * @since 17.06.2019
 */
public class MapTest {

    /*
    В хеш-таблице будет один объект.
    Так как теперь методы equals() и hashCode()
    переопределены в классе и работают как нужно, то
    при добавлении второго объекта
    в хеш-таблицу проверка на равенство
    и hashCode() и equals() вернет истину. Поэтому объект
    перезапишется.
    И в итоге в коллекции будет лежать только один
    объект.
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
