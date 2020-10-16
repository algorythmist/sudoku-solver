package com.tecacet.games.sudoku.gui;

import javax.swing.JComponent;

public interface SudokuView {

    void setValue(int row, int col, int value);

    void clear();

    /**
     * Refresh screen from the game board
     */
    void refresh();

    void clear(int row, int col);

    JComponent getComponent();

}