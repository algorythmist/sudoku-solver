package com.tecacet.games.sudoku;

/**
 * Represents information about a cell on the Sudoku board A cell is uniquely
 * identified by its coordinates
 */
public class Cell {

	private static final int BOARD_SIZE = 9;
	private int row;
	private int col;

	public Cell(int r, int c) {
		row = r;
		col = c;
	}

	public Cell(Cell cell) {
		row = cell.row;
		col = cell.col;
	}

	public int hashCode() {
		return Integer.valueOf((BOARD_SIZE + 1) * row + col).hashCode();
	}

	public boolean equals(Object o) {
		Cell c = (Cell) o;
		return row == c.row && col == c.col;
	}

	public String toString() {
		return String.format("(%d,%d)", (row + 1), (col + 1));
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return col;
	}

}
