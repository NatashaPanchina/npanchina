package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * Black Rook.
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 18.08.2018
 */
public class RookBlack extends Figure {

    public RookBlack(final Cell position) {
        super(position);
    }

    public Cell position() {
        return this.position;
    }

    @Override
    public Figure copy(Cell dest) {
        return new RookBlack(dest);
    }

    @Override
    public boolean isMove(Cell source, Cell dest) {
        boolean result = false;
        if (source.getX() == dest.getX() || source.getY() == dest.getY()) {
            result = true;
        }
        return result;
    }
}
