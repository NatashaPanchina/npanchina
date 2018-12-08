package ru.job4j.departments;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 8.12.2018
 */
public class SortDepartmentsTest {
    @Test
    public void whenSortAscending() {
        ArrayList<String> departments = new ArrayList<>();
        departments.add("K1\\SK1");
        departments.add("K1\\SK2");
        departments.add("K1\\SK1\\SSK1");
        departments.add("K1\\SK1\\SSK2");
        departments.add("K1");
        departments.add("K2\\SK1\\SSK1");
        departments.add("K2\\SK1\\SSK2");
        departments.add("K2\\SK1");
        departments.add("K2");
        ArrayList<String> expected = new ArrayList<>();
        expected.add("K1");
        expected.add("K1\\SK1");
        expected.add("K1\\SK1\\SSK1");
        expected.add("K1\\SK1\\SSK2");
        expected.add("K1\\SK2");
        expected.add("K2");
        expected.add("K2\\SK1");
        expected.add("K2\\SK1\\SSK1");
        expected.add("K2\\SK1\\SSK2");
        SortDepartments sort = new SortDepartments();
        assertThat(sort.sort(departments, 0), is(expected));
    }

    @Test
    public void whenSortDescending() {
        ArrayList<String> departments = new ArrayList<>();
        departments.add("K1\\SK1");
        departments.add("K1\\SK2");
        departments.add("K1\\SK1\\SSK1");
        departments.add("K1\\SK1\\SSK2");
        departments.add("K1");
        departments.add("K2\\SK1\\SSK1");
        departments.add("K2\\SK1\\SSK2");
        departments.add("K2\\SK1");
        departments.add("K2");
        ArrayList<String> expected = new ArrayList<>();
        expected.add("K2");
        expected.add("K2\\SK1");
        expected.add("K2\\SK1\\SSK2");
        expected.add("K2\\SK1\\SSK1");
        expected.add("K1");
        expected.add("K1\\SK2");
        expected.add("K1\\SK1");
        expected.add("K1\\SK1\\SSK2");
        expected.add("K1\\SK1\\SSK1");
        SortDepartments sort = new SortDepartments();
        assertThat(sort.sort(departments, 1), is(expected));
    }
}
