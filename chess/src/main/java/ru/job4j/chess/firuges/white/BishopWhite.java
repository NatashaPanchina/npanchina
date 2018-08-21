package ru.job4j.chess.firuges.white;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * White Bishop.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 18.08.2018.
 */
public class BishopWhite extends Figure {

    public BishopWhite(final Cell position) {
        super(position);
    }

    public Cell position() {
        return this.position;
    }

    @Override
    public boolean isMove(Cell source, Cell dest) {
        boolean result = false;
        int deltax = Math.abs(source.getX() - dest.getX());
        int deltay = Math.abs(source.getY() - dest.getY());
        if (deltax - deltay == 0) {
            result = true;
        }
        return result;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopWhite(dest);
    }
}
