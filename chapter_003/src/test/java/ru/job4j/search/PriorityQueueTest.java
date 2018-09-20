package ru.job4j.search;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 19.09.2018
 */
public class PriorityQueueTest {
    @Test
    public void whenHigherPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("middle", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("low", 7));
        assertThat(queue.take().getDesc(), is("urgent"));
        assertThat(queue.take().getDesc(), is("middle"));
        assertThat(queue.take().getDesc(), is("low"));
    }
}
