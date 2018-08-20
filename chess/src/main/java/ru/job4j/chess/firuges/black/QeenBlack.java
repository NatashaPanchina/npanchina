package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * Black Queen.
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 18.08.2018
 */
public class QeenBlack extends Figure {

    public QeenBlack(final Cell position) {
        super(position);
    }

    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        if(!this.isMove(source, dest)) throw new ImpossibleMoveException();
        int size = source.getX() == dest.getX() ? Math.abs(source.getY() - dest.getY()) : Math.abs(source.getX() - dest.getX());
        Cell[] steps = new Cell[size];
        int deltax = 0;
        int deltay = 0;
        if (source.getX() > dest.getX()) {
            deltax = -1;
        } else if (source.getX() < dest.getX()) {
            deltax = 1;
        }
        if (source.getY() > dest.getY()) {
            deltay = -1;
        } else if (source.getY() < dest.getY()) {
            deltay = 1;
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
        return new QeenBlack(dest);
    }

    public boolean isMove(Cell source, Cell dest) {
        boolean result = false;
        int delta = Math.abs(source.getX() - dest.getX());
        if (source.getX() - delta == dest.getX() && source.getY() - delta == dest.getY()
                || source.getX() + delta == dest.getX() && source.getY() + delta == dest.getY()
                || source.getX() + delta == dest.getX() && source.getY() - delta == dest.getY()
                || source.getX() - delta == dest.getX() && source.getY() + delta == dest.getY()
                || source.getX() == dest.getX() || source.getY() == dest.getY()) {
            result = true;
        }
        return result;
    }
}