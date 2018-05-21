package ru.job4j.max;

/**
 * Maximum.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Max {
    /**
     * Method max
     * @param first number
     * @param second number
     * @return maximum
     */
    public int max(int first, int second) {
        return  first > second ? first : second;
    }

    /**
     * Method max
     * @param first number
     * @param second number
     * @param third number
     * @return maximum
     */
    public int max(int first, int second, int third) {
        int temp = this.max(first, second);
        temp = this.max(temp, third);
        return temp;
    }
}
