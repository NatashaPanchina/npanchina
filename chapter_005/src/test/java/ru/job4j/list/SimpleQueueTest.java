package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 1.03.2019
 */
public class SimpleQueueTest {
    @Test
    public void whenAddElementsThanMethodPollShouldReturnFirstAddedElement() {
        SimpleQueue<Integer> simpleQueue = new SimpleQueue<>();
        simpleQueue.push(0);
        simpleQueue.push(1);
        simpleQueue.push(2);
        assertThat(simpleQueue.poll(), is(0));
        simpleQueue.push(3);
        assertThat(simpleQueue.poll(), is(1));

    }
}
