package ru.job4j.chess.firuges.white;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * White Knight.
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 18.08.2018
 */
public class KnightWhite extends Figure {

    public KnightWhite(final Cell position) {
        super(position);
    }

    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        if (!this.isMove(source, dest)) {
            throw new ImpossibleMoveException();
        }
        Cell[] steps = new Cell[]{dest};
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new KnightWhite(dest);
    }

    @Override
    public boolean isMove(Cell source, Cell dest) {
        boolean result = false;
        if (source.getX() - 1 == dest.getX() && source.getY() - 2 == dest.getY()
                || source.getX() - 2 == dest.getX() && source.getY() - 1 == dest.getY()
                || source.getX() - 1 == dest.getX() && source.getY() + 2 == dest.getY()
                || source.getX() + 1 == dest.getX() && source.getY() - 2 == dest.getY()
                || source.getX() + 2 == dest.getX() && source.getY() - 1 == dest.getY()
                || source.getX() + 2 == dest.getX() && source.getY() + 1 == dest.getY()
                || source.getX() + 1 == dest.getX() && source.getY() + 2 == dest.getY()
                || source.getX() - 2 == dest.getX() && source.getY() + 1 == dest.getY()) {
            result = true;
        }
        return result;
    }
}
