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
 * @version 3
 * @since 17.06.2019
 */
public class MapTest {

    /*
    В хеш-таблице все еще будут храниться  два объекта.
    Потому что при добавлении объекта в хеш-таблицу
    сначала вызывается метод hashCode, и после удачной проверки хеш-кодов
    на равенство вызывается equals(). Но в данном случае метод hashCode()
    не переопределен, соответственно для двух наших объектов
    вернется разный хеш-код и equals() вообще не вызовется. В итоге
    метод put() добавит второй объект в таблицу.
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
