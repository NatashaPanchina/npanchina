package ru.job4j.list;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 26.02.2019
 */
public class DynamicListTest {
    @Test(expected = ConcurrentModificationException.class)
    public void whenTransformListThenIteratorThrowsException() {
        DynamicList<String> dynamicList = new DynamicList<>();
        dynamicList.add("0");
        dynamicList.add("1");
        Iterator<String> it = dynamicList.iterator();
        dynamicList.add("2");
        it.next();
    }

    @Test
    public void whenContainerIsFullThenContainerIsIncreasedTwice() {
        DynamicList<String> dynamicList = new DynamicList<>(2);
        dynamicList.add("0");
        dynamicList.add("1");
        assertThat(dynamicList.length(), is(2));
        dynamicList.add("2");
        assertThat(dynamicList.length(), is(4));
    }
}
