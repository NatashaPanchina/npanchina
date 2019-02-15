package ru.job4j.generic;

import org.junit.Test;
import org.junit.Before;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 14.02.2019
 */
public class SimpleArrayTest {
    SimpleArray<Integer> simpleArray;

    @Before
    public void create() {
        simpleArray = new SimpleArray<>(3);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddUnnecessaryElementThenThrowException() {
        simpleArray.add(4);
    }

    @Test
    public void whenSetElementThenArrayShouldHaveNewValue() {
        simpleArray.set(0, 10);
        assertThat(simpleArray.get(0), is(10));
    }

    @Test
    public void whenRemoveElementFromArrayThanElementsShouldMove() {
        simpleArray.remove(1);
        assertThat(simpleArray.get(1), is(3));
    }

    @Test
    public void whenCreateArrayIterator() {
        Iterator<Integer> it = simpleArray.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(false));
    }
}
