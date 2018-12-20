package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Phone Dictionary.
 *
 * @author Natasha Panchina
 * @version 2
 * @since 19.09.2018
 */
public class PhoneDictionary {
    private List<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подошедших пользователей.
     */
    public List<Person> find(String key) {
        var stream = this.persons.stream().filter(
                person -> person.getName().contains(key)
                        || person.getSurname().contains(key)
                        || person.getPhone().contains(key)
                        || person.getAddress().contains(key)
        );
        return stream.collect(Collectors.toList());
    }
}
