package ru.job4j.chess.firuges;

import ru.job4j.chess.ImpossibleMoveException;

/**
 * Описывает поведение шахматной доски.
 * Figure.
 *
 * @author Natasha Panchina
 * @version 1
 * @since 18.08.2018
 */
public abstract class Figure {
    /**
     * figure's position.
     */
    public final Cell position;

    protected Figure(final Cell position) {
        this.position = position;
    }

    /**
     * Method way.
     * @param source coordinate.
     * @param dest - destination coordinate.
     * @return way that the figure must move.
     * @throws ImpossibleMoveException - if figure can't move.
     */
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        if (!this.isMove(source, dest)) {
            throw new ImpossibleMoveException();
        }
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

    /**
     * method icon.
     * @return image of figure.
     */
    public String icon() {
        return String.format(
                "%s.png", this.getClass().getSimpleName()
        );
    }

    /**
     * Method isMove.
     * @param source coordinate.
     * @param dest - destination coordinate.
     * @return true if the figure can move to the destination coordinate.
     *         false - if it can't.
     */
    abstract public boolean isMove(Cell source, Cell dest);

    /**
     * Create a figure with this coordinate.
     * @param dest - coordinate of the figure.
     * @return a new figure.
     */
    abstract public Figure copy(Cell dest);
}
