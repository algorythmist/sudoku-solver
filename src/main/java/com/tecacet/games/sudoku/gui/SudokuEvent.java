package com.tecacet.games.sudoku.gui;

import com.tecacet.games.sudoku.Cell;

public class SudokuEvent {

	public static final int SOLVE_ACTION = 1;
	public static final int UNDO_ACTION = 2;
	public static final int CLEAR_ACTION = 3;
	public static final int MOVE_ACTION = 4;
	public static final int SELECT_ACTION = 5;

	private Cell cell = null;
	private int type;
	private Integer value = null;

	public SudokuEvent(int type, Cell cell, Integer value) {
		this(type);
		this.cell = cell;
		this.value = value;
	}

	public SudokuEvent(int type) {
		this.type = type;
	}

	public Cell getCell() {
		return cell;
	}

	public int getType() {
		return type;
	}

	public Integer getValue() {
		return value;
	}

}
