package ru.job4j.loop;

/**
 * Factorial.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Factorial {
    /**
     * Method calc.
     * @param n - number
     * @return factorial
     */
    public int calc(int n) {
        int factorial = 1;
        if (n == 0) {
            return factorial;
        }
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
