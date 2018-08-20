package ru.job4j.chess;

/**
 * OccupiedWayException.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 18.08.2018
 */
public class OccupiedWayException extends Exception {
    public OccupiedWayException() {
        super("Way is occupied!");
    }
}
