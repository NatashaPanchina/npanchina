package ru.job4j.chess;

/**
 * FigureNotFoundException
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 18.08.2018
 */
public class FigureNotFoundException extends Exception {
    public FigureNotFoundException() {
        super("Figure is not found!");
    }
}
