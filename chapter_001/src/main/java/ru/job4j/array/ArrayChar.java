package ru.job4j.array;

/**
 * Обертка над строкой.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ArrayChar {
    private char[] data;

    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Проверяет что слово начинается с префикса.
     * @param prefix префикс.
     * @return если слово начинается с префикса.
     */
    public boolean startWith(String prefix) {
        boolean result = true;
        char[] array = prefix.toCharArray();
        for (int index = 0; index < array.length; index++) {
            if (this.data[index] != array[index]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
