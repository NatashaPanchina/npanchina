package ru.job4j.students;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 20.12.2018
 */
public class FilterTest {
    @Test
    public void whenFilterStudents() {
        Student first = new Student("Peter", 23);
        Student second = new Student("Ivan", 14);
        Student third = new Student("Glory", 37);
        Student fourth = new Student("Jay", 19);
        List<Student> input = Arrays.asList(null, first, second, third, null, fourth);
        Filter filter = new Filter();
        List<Student> result = filter.levelOf(input, 20);
        assertThat(result, is(Arrays.asList(third, first)));
    }
}
