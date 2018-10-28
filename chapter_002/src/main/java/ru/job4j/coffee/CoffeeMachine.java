package ru.job4j.coffee;

import java.util.ArrayList;

/**
 * Coffee Machine.
 *
 * @author Natasha Panchina
 * @version 1
 * @since 13.09.2018
 */
public class CoffeeMachine {
    /**
     * Method changes.
     * @param value - Shoved banknote.
     * @param price of a coffee.
     * @return leftover.
     */
    public ArrayList<Integer> changes(int value, int price) {
        ArrayList<Integer> result = new ArrayList<>();
        int leftover = value - price;
        int count = 0;
        for (Coin coins : Coin.values()) {
            while (true) {
                count += coins.getNominal();
                if (count > leftover) {
                    break;
                }
                result.add(coins.getNominal());
            }
            count -= coins.getNominal();
        }
        return result;
    }
}
