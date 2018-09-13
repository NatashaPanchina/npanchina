package ru.job4j.coffee;

/**
 * Coins.
 *
 * @author Natasha Panchina
 * @version 1
 * @since 13.09.2018
 */
public enum Coin {
    TEN(10), FIVE(5), TWO(2), ONE(1);

    private int nominal;

    Coin(int nominal) {
        this.nominal = nominal;
    }

    public int getNominal() {
        return this.nominal;
    }
}
