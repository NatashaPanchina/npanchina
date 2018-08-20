package ru.job4j.chess.firuges.white;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * White Rook.
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 18.08.2018
 */
public class RookWhite extends Figure {

    public RookWhite(final Cell position) {
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
        int size = source.getX() == dest.getX() ? Math.abs(source.getY() - dest.getY()) : Math.abs(source.getX() - dest.getX());
        Cell[] steps = new Cell[size];
        int deltax = 0;
        int deltay = 0;
        if (source.getX() != dest.getX()) {
            deltax  = source.getX() > dest.getX() ? -1 : 1;
        }
        if (source.getY() != dest.getY()) {
            deltay = source.getY() > dest.getY() ? -1 : 1;
        }
        int x = source.getX() + deltax;
        int y = source.getY() + deltay;
        for (int index = 0; index < size; index++) {
            steps[index] = Cell.findByCoordinate(x, y);
            x = x + deltax;
            y = y + deltay;
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new RookWhite(dest);
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
