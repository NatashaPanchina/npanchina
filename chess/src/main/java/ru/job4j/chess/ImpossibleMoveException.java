package ru.job4j.chess;

/**
 * ImpossibleMoveException.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 18.08.2018
 */
public class ImpossibleMoveException extends Exception {
    public ImpossibleMoveException() {
         super("Figure can't move to destination!");
    }
}
