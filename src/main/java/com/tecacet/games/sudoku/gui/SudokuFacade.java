package com.tecacet.games.sudoku.gui;

public interface SudokuFacade {

	public void setValue(int row, int col, Integer value);
	
	/**
	 * Clear all cells and restart game
	 */
	public void clear();
	
	/**
	 * Play the next move
	 */
	public void move();
	
	/**
	 * Solve the game
	 */
	public void solve();
	
	
}
