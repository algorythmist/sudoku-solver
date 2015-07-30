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

	private Set<Integer> assignedValues = new HashSet<Integer>();

	private Map<Integer, Set<Cell>> unassignedValues = new HashMap<Integer, Set<Cell>>();

	private Sudoku game;
	private int startRow;
	private int startCol;

	public Neighborhood(Sudoku game, int startRow, int startCol) {
		super();
		this.game = game;
		this.startRow = startRow;
		this.startCol = startCol;
	}

	public void populateValueMap() {
		for (int i = 1; i <= 9; i++) {
			if (contains(i)) {
				continue;
			}
			populateValue(i);
		}
	}

	private void populateValue(int i) {
		unassignedValues.put(i, new HashSet<Cell>());
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
		Integer v = new Integer(value);
		if (assignedValues.contains(v)) {
			return false;
		}
		assignedValues.add(v);
		unassignedValues.remove(v);
		return true;
	}

	public boolean contains(int value) {
		return assignedValues.contains(new Integer(value));
	}

	public boolean removeValue(Integer value) {
		populateValue(value);
		return assignedValues.remove(value);
	}

	public Map<Integer, Set<Cell>> getUnassignedValues() {
		return unassignedValues;
	}

}