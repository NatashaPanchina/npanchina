package ru.job4j.loop;

/**
 * Counter.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Counter {
    /**
     * Method add
     * @param start
     * @param finish
     * @return sum of even numbers
     */
    public int add(int start, int finish) {
        int sum = 0;
        for(int index = start; index <= finish; index++) {
            if((index % 2) == 0) {
                sum += index;
            }
        }
        return sum;
    }
}
