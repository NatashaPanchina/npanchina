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
 * @version 2
 * @since 28.02.2019
 */
public class DynamicLinkedListTest {
    @Test(expected = ConcurrentModificationException.class)
    public void whenTransformListThenIteratorThrowsException() {
        DynamicLinkedList<Integer> dynamicLinkedList = new DynamicLinkedList<>();
        dynamicLinkedList.add(0);
        Iterator<Integer> it = dynamicLinkedList.iterator();
        dynamicLinkedList.add(1);
        it.next();
    }

    @Test
    public void whenContainerIsFullThenContainerIsIncreased() {
        DynamicLinkedList<Integer> dynamicLinkedList = new DynamicLinkedList<>();
        dynamicLinkedList.add(0);
        assertThat(dynamicLinkedList.size(), is(1));
        dynamicLinkedList.add(1);
        assertThat(dynamicLinkedList.size(), is(2));
    }

    @Test
    public void whenAddElementThanMethodNextShouldGetThisElement() {
        DynamicLinkedList<Integer> dynamicLinkedList = new DynamicLinkedList<>();
        dynamicLinkedList.add(0);
        dynamicLinkedList.add(1);
        Iterator<Integer> it = dynamicLinkedList.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(0));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(false));
    }
}
