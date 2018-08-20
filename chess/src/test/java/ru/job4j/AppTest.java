package ru.job4j;

import ru.job4j.chess.Logic;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.KnightBlack;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Test.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 19.08.2018
 */
public class AppTest {
    Logic logic = new Logic();
    boolean result = false;

    @Test
    public void whenBishopMovesToDest() {
        logic.add(new BishopBlack(Cell.D4));
        result = logic.move(Cell.D4, Cell.A7);
        assertThat(result, is(true));
    }

    @Test
    public void whenFigureIsNotFound() {
        logic.add(new BishopBlack(Cell.A1));
        result = logic.move(Cell.A2, Cell.C4);
        assertThat(result, is(false));
    }

    @Test
    public void whenWayIsNotClean() {
        logic.add(new BishopBlack(Cell.A1));
        logic.add(new BishopBlack(Cell.C3));
        result = logic.move(Cell.A1, Cell.D4);
        assertThat(result, is(false));
    }

    @Test
    public void whenKnightMovesToDest() {
        logic.add(new KnightBlack(Cell.E2));
        result = logic.move(Cell.E2, Cell.D4);
        assertThat(result, is(true));
    }

    @Test
    public void whenKnightsDestinationIsNotClean() {
        logic.add(new KnightBlack(Cell.E2));
        logic.add(new BishopBlack(Cell.D4));
        result = logic.move(Cell.E2, Cell.D4);
        assertThat(result, is(false));
    }
}
