package ru.job4j.chess.firuges.white;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * White Queen.
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 18.08.2018
 */
public class QeenWhite extends Figure {

    public QeenWhite(final Cell position) {
        super(position);
    }

    public Cell position() {
        return this.position;
    }

    @Override
    public Figure copy(Cell dest) {
        return new QeenWhite(dest);
    }

    public boolean isMove(Cell source, Cell dest) {
        boolean result = false;
        int deltax = Math.abs(source.getX() - dest.getX());
        int deltay = Math.abs(source.getY() - dest.getY());
        if (deltax - deltay == 0
                || source.getX() == dest.getX()
                || source.getY() == dest.getY()) {
            result = true;
        }
        return result;
    }
}

