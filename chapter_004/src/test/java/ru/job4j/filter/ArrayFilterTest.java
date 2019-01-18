package ru.job4j.filter;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 18.01.2019
 */
public class ArrayFilterTest {
    @Test
    public void whenFilterArray() {
        ArrayFilter filter = new ArrayFilter();
        int[] input = {1, 2, 3, 4, 5, 6};
        assertThat(filter.filter(input), is(56));
    }
}
