package ru.job4j.generic;

import org.junit.Test;
import org.junit.Before;
import ru.job4j.list.SimpleArrayList;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 21.02.2019
 */
public class SimpleArrayListTest {

    private SimpleArrayList<Integer> list;

    @Before
    public void beforeTest() {
        list = new SimpleArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(list.get(1), is(2));
    }

    @Test
    public void whenAddThreeElementsThenUseGetSizeResult() {
        assertThat(list.getSize(), is(3));
    }

    @Test
    public void whenDeleteElementThenUseGetElementValue() {
        assertThat(list.delete(), is(3));
    }
}
