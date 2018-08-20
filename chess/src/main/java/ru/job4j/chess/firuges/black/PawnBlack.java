package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.Cell;

/**
 * Black Pawn.
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 18.08.2018
 */
public class PawnBlack extends Figure {

    public PawnBlack(final Cell position) {
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
        return new PawnBlack(dest);
    }

    @Override
    public boolean isMove(Cell source, Cell dest) {
        boolean result = false;
        if (source.getY() == dest.getY() + 1 && source.getX() == dest.getX()) {
            result = true;
        }
        return result;
    }
}
