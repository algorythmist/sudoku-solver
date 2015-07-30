package com.tecacet.games.sudoku.gui;

import java.io.IOException;

import javax.swing.JMenuBar;
import javax.swing.JPanel;


import com.tecacet.games.sudoku.BestCellStrategy;
import com.tecacet.games.sudoku.CombinedStrategy;
import com.tecacet.games.sudoku.Sudoku;
import com.tecacet.games.sudoku.io.ClasspathGameReader;
import com.tecacet.games.sudoku.io.GameReader;

public class SudokuAssembler {

    private SudokuPanel panel;
    private JMenuBar bar;
    
    public void assemble() throws IOException {
	GameReader reader = new ClasspathGameReader();
	Sudoku game = new Sudoku();
	reader.read(game, "evil1.sud");
	BestCellStrategy player = new CombinedStrategy(game);
	SudokuController controller = new SudokuController(game, player);
	SudokuView view = new TextSudokuView(game, controller);
	panel = new SudokuPanel(view, controller);
	bar = MenuBuilder.getMenuBar(controller, panel);
    }
    
    public JPanel getMainPanel() {
	return panel;
    }
    
    public JMenuBar getMenuBar() {
	return bar;
    }
}
