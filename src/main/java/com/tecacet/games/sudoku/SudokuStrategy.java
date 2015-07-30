package com.tecacet.games.sudoku;

/**
 * 
 * A Sudoku Strategy for solving Sudoku problems
 *
 */
//TODO this interface is not very clean
public interface SudokuStrategy {

	/**
	 * Solve the entire Sudoku game
	 */
	void solve();
	
	/**
	 * Select and perform the next move on the board
	 * @return the performed move
	 */
	Move move() ;
	
	/**
	 * Undo the last move
	 * @return the undone move
	 */
	Move undo();


}