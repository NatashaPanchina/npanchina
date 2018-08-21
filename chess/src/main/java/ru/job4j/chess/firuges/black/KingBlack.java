package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * Black King.
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 18.08.2018
 */
public class KingBlack extends Figure {

    public KingBlack(final Cell position) {
        super(position);
    }

    public Cell position() {
        return this.position;
    }

    @Override
    public Figure copy(Cell dest) {
        return new KingBlack(dest);
    }

    @Override
    public boolean isMove(Cell source, Cell dest) {
        boolean result = false;
        int deltax = Math.abs(source.getX() - dest.getX());
        int deltay = Math.abs(source.getY() - dest.getY());
        if (deltax + deltay == 1
                || deltax + deltay == 2 && deltax == 1) {
            result = true;
        }
        return result;
    }
}
