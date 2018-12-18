package ru.job4j.chess;

import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.Cell;

import java.util.Arrays;
import java.util.List;

/**
 * Logic.
 *
 * @author Natasha Panchina (panchinanata25@gmail.com)
 * @version 1
 * @since 18.08.2018
 * @version 2
 * @since 18.12.2018
 */
public class Logic {
    //the all figures.
    private Figure[] figures = new Figure[32];

    private int index = 0;

    /**
     * Method add a figure.
     * @param figure
     */
    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    /**
     * Method move.
     * @param source coordinate.
     * @param dest - destination coordinate.
     * @return true if the operation was successful.
     */
    public boolean move(Cell source, Cell dest) {
        boolean result = false;
        int index = 0;
        Cell[] steps;
        try {
            index = this.findBy(source);
            steps = this.figures[index].way(source, dest);
            this.checkCells(steps);
            if (steps.length > 0 && steps[steps.length - 1].equals(dest)) {
                result = true;
                this.figures[index] = this.figures[index].copy(dest);
            }
        } catch (FigureNotFoundException exc) {
            System.out.println(exc);
        } catch (ImpossibleMoveException exc) {
            System.out.println(exc);
        } catch (OccupiedWayException exc) {
            System.out.println(exc);
        }
        return  result;
    }

    /**
     * Method clean.
     */
    public void clean() {
        Arrays.stream(this.figures).forEach(element -> element = null);
        this.index = 0;
    }

    /**
     * Method findBy.
     * @param cell - coordinate of figure.
     * @return index of the figure.
     */
    private int findBy(Cell cell) throws FigureNotFoundException {
        final int[] result = {-1};
        List<Figure> figuresList = Arrays.asList(this.figures);
        figuresList.stream().forEach(
                figure -> {
                    if (figure != null && figure.position.equals(cell)) {
                        result[0] = figuresList.indexOf(figure);
                    }
                }
        );
        if (result[0] == -1) {
            throw new FigureNotFoundException();
        }
        return result[0];
    }

    /**
     * Method check Cells.
     * @param steps - way of the figure.
     * @throws OccupiedWayException if the way is not empty.
     */
    private void checkCells(Cell[] steps) throws OccupiedWayException {
        for (Cell step : steps) {
            try {
                if (this.findBy(step) != -1) {
                    throw new OccupiedWayException();
                }
            } catch (FigureNotFoundException exc) {
            }
        }
    }
}
