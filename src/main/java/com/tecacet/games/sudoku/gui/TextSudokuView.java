package com.tecacet.games.sudoku.gui;

import com.tecacet.games.sudoku.Sudoku;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class TextSudokuView extends JPanel implements SudokuView {

    private final TextFieldCell[][] cells;
    private final Sudoku game;

    public TextSudokuView(Sudoku game, SudokuController controller) {
        this.game = game;
        cells = new TextFieldCell[game.getSize()][game.getSize()];
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setLayout(new GridLayout(3, 3));
        JPanel[][] innerGrids = new JPanel[3][3];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int row = i / 3;
                int col = j / 3;
                if ((i % 3 == 0) && (j % 3 == 0)) {
                    innerGrids[row][col] = new JPanel();
                    innerGrids[row][col].setLayout(new GridLayout(3, 3));
                    innerGrids[row][col].setBorder(BorderFactory
                            .createLineBorder(Color.black));
                    this.add(innerGrids[row][col]);
                }
                cells[i][j] = new TextFieldCell(i, j);
                cells[i][j].addActionListener(controller);
                cells[i][j].addSudokuEventListener(controller);
                cells[i][j].setValue(game.getValue(i, j));
                innerGrids[row][col].add(cells[i][j]);
            }
        }

    }

    @Override
    public void setValue(int row, int col, int value) {
        cells[row][col].setValue(value);
    }

    @Override
    public void clear() {
        for (int i = 0; i < game.getSize(); i++) {
            for (int j = 0; j < game.getSize(); j++) {
                cells[i][j].setValue(null);
            }
        }
    }

    @Override
    public void refresh() {
        for (int i = 0; i < game.getSize(); i++) {
            for (int j = 0; j < game.getSize(); j++) {
                Integer v = game.getValue(i, j);
                cells[i][j].setValue(v);
            }
        }
    }

    @Override
    public void clear(int row, int col) {
        cells[row][col].setValue(null);
    }

    public JComponent getComponent() {
        return this;
    }
}
