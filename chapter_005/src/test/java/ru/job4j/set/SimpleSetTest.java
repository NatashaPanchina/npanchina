package ru.job4j.set;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 6.03.2019
 */
public class SimpleSetTest {
    private SimpleSet<String> set;

    @Before
    public void create() {
        set = new SimpleSet<>();
        set.add("A");
        set.add("B");
        set.add("C");
    }

    @Test
    public void whenAddDuplicateThenReturnFalse() {
        assertThat(this.set.add("B"), is(false));
    }

    @Test
    public void whenGetIterator() {
        Iterator<String> it = this.set.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("A"));
        assertThat(it.next(), is("B"));
        assertThat(it.next(), is("C"));
        assertThat(it.hasNext(), is(false));
    }
}
