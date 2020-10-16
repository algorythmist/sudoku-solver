package com.tecacet.games.sudoku.gui;

public interface SudokuFacade {

    void setValue(int row, int col, Integer value);

    /**
     * Clear all cells and restart game
     */
    void clear();

    /**
     * Play the next move
     */
    void move();

    /**
     * Solve the game
     */
    void solve();


}
