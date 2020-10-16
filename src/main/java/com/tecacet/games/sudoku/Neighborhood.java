package com.tecacet.games.sudoku;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Represents a square neighborhood subject to the restriction that each value should appear only once.
 * In this representation, a neighborhood is identified by its start row and column.
 * The neighborhood keeps a set of values that have been filled in.
 * For each value that has not been filled in, a neighborhood keeps a collection of cells where these values could appear
 */
public class Neighborhood {

    private final Set<Integer> assignedValues = new HashSet<>();
    private final Map<Integer, Set<Cell>> unassignedValues = new HashMap<>();

    private final Sudoku game;
    private final int startRow;
    private final int startCol;

    public Neighborhood(Sudoku game, int startRow, int startCol) {
        super();
        this.game = game;
        this.startRow = startRow;
        this.startCol = startCol;
    }

    private void populateValue(int i) {
        unassignedValues.put(i, new HashSet<>());
        // else assemble the possibilities
        for (int row = startRow; row < startRow + 3; row++) {
            for (int col = startCol; col < startCol + 3; col++) {
                if (game.getValue(row, col) == null
                        && game.isValidValue(row, col, i)) {
                    unassignedValues.get(i).add(new Cell(row, col));
                }
            }
        }
    }

    public boolean addValue(int value) {
        if (assignedValues.contains(value)) {
            return false;
        }
        assignedValues.add(value);
        unassignedValues.remove(value);
        return true;
    }

    public boolean contains(int value) {
        return assignedValues.contains(value);
    }

    public boolean removeValue(Integer value) {
        populateValue(value);
        return assignedValues.remove(value);
    }

    public Map<Integer, Set<Cell>> getUnassignedValues() {
        return unassignedValues;
    }

}