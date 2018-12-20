package ru.job4j.departments;

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
 * @since 8.12.2018
 * @version 3
 * @since 20.12.2018
 */
public class SortDepartmentsTest {

    List<String> departments = List.of(
            "K1\\SK1",
            "K1\\SK2",
            "K1\\SK1\\SSK1",
            "K1\\SK1\\SSK2",
            "K2",
            "K2\\SK1\\SSK1",
            "K2\\SK1\\SSK2"
    );

    @Test
    public void whenSortAscending() {
        Set<String> expected = Set.of(
                "K1\\SK1",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K1\\SK2",
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2",
                "K1"
        );
        SortDepartments sort = new SortDepartments();
        assertThat(sort.sort(departments, 0), is(expected));
    }

    @Test
    public void whenSortDescending() {
        Set<String> expected = Set.of(
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK2",
                "K2\\SK1\\SSK1",
                "K1",
                "K1\\SK2",
                "K1\\SK1",
                "K1\\SK1\\SSK2",
                "K1\\SK1\\SSK1"
        );
        SortDepartments sort = new SortDepartments();
        assertThat(sort.sort(departments, 1), is(expected));
    }
}
