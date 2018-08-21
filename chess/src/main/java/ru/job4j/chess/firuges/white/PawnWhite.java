package ru.job4j.chess.firuges.white;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * White Pawn.
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 18.08.2018
 */
public class PawnWhite extends Figure {

    public PawnWhite(final Cell position) {
        super(position);
    }

    public Cell position() {
        return this.position;
    }

    @Override
    public Figure copy(Cell dest) {
        return new PawnWhite(dest);
    }

    @Override
    public boolean isMove(Cell source, Cell dest) {
        boolean result = false;
        if (source.getY() == dest.getY() - 1 && source.getX() == dest.getX()) {
            result = true;
        }
        return result;
    }
}

