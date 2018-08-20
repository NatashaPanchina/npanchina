package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.ImpossibleMoveException;

/**
 * Black Bishop.
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 18.08.2018
 */
public class BishopBlack extends Figure {

    public BishopBlack(final Cell position) {
        super(position);
    }

    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        if(!this.isMove(source, dest)) throw new ImpossibleMoveException();
        int size = Math.abs(source.getX() - dest.getX());
        Cell[] steps = new Cell[size];
        int deltax = source.getX() > dest.getX() ? -1 : 1;
        int deltay = source.getY() > dest.getY() ? -1 : 1;
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
        return new BishopBlack(dest);
    }

    @Override
    public boolean isMove(Cell source, Cell dest) {
        boolean result = false;
        int delta = Math.abs(source.getX() - dest.getX());
        if (source.getX() - delta == dest.getX() && source.getY() - delta == dest.getY()
                || source.getX() + delta == dest.getX() && source.getY() + delta == dest.getY()
                || source.getX() + delta == dest.getX() && source.getY() - delta == dest.getY()
                || source.getX() - delta == dest.getX() && source.getY() + delta == dest.getY()) {
            result = true;
        }
        return result;
    }
}
