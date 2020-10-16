package com.tecacet.games.sudoku;

import java.util.ArrayList;
import java.util.List;

/**
 * A move represents a player's choice. It consists of a cell and a list of
 * valid values for that cell. The values are applied in the order they appear
 * on the list
 */
public class Move {

    private final Cell cell;
    private final List<Integer> available;

    public Move(Cell cell, List<Integer> values) {
        this.cell = new Cell(cell);
        available = new ArrayList<>();
        available.addAll(values);
    }

    public Move(Cell cell, Integer value) {
        this.cell = new Cell(cell);
        available = new ArrayList<>();
        available.add(value);
    }

    public boolean crossOut() {
        available.remove(0);
        return !available.isEmpty();
    }

    public int getRow() {
        return cell.getRow();
    }

    public int getColumn() {
        return cell.getColumn();
    }

    public int getValue() {
        return available.get(0);
    }

    public String toString() {
        return cell.toString() + " = " + getValue() + " " + available.toString();
    }

}
