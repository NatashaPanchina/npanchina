package ru.job4j.coffee;

import org.junit.Test;
import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 13.09.2018
 */
public class CoffeeMachineTest {
    @Test
    public void whenValueIs100AndPriceIs53() {
        CoffeeMachine machine = new CoffeeMachine();
        ArrayList<Integer> result = machine.changes(100, 53);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(10);
        expected.add(10);
        expected.add(10);
        expected.add(10);
        expected.add(5);
        expected.add(2);
        assertThat(result, is(expected));
    }
}
