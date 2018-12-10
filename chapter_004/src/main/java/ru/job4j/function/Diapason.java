package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Diapason.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 10.12.2018
 */
public class Diapason {
    /**
     * Method diapason
     * @param start
     * @param end
     * @param func - function
     * @return list of function
     */
    public List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> result = new ArrayList<>();
        for (int index = start; index <= end; index++) {
            result.add(func.apply((double) index));
        }
        return result;
    }
}
