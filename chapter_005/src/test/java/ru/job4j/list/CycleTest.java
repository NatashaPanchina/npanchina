package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 5.03.2019
 */
public class CycleTest {
    @Test
    public void whenListHasCycleThanReturnTrue() {
        Cycle cycle = new Cycle();
        Node<Integer> first = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> four = new Node<>(4);
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;
        assertThat(cycle.hasCycle(first), is(true));
    }

    @Test
    public void whenNoCycleThanReturnFalse() {
        Cycle cycle = new Cycle();
        Node<Integer> first = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> four = new Node<>(4);
        first.next = two;
        two.next = third;
        third.next = four;
        assertThat(cycle.hasCycle(first), is(false));
    }

    @Test
    public void whenOneNodeInList() {
        Cycle cycle = new Cycle();
        Node<Integer> first = new Node<>(1);
        assertThat(cycle.hasCycle(first), is(false));
    }
}
