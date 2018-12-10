package ru.job4j.function;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 10.12.2018
 */
public class DiapasonTest {
    @Test
    public void whenLineFunction() {
        Diapason diapason = new Diapason();
        List<Double> result = diapason.diapason(1, 5, (value) -> value);
        assertThat(result, is(Arrays.asList(1d, 2d, 3d, 4d, 5d)));
    }

    @Test
    public void whenQuadraticFunction() {
        Diapason diapason = new Diapason();
        List<Double> result = diapason.diapason(1, 5, (value) -> value * value);
        assertThat(result, is(Arrays.asList(1d, 4d, 9d, 16d, 25d)));
    }

    @Test
    public void whenLogFunction() {
        Diapason diapason = new Diapason();
        List<Double> result = diapason.diapason(1, 4, (value) -> Math.log(value));
        assertThat(result, is(Arrays.asList(Math.log(1), Math.log(2), Math.log(3), Math.log(4))));
    }
}
