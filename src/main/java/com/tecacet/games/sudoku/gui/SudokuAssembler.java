package com.tecacet.games.sudoku.gui;

import com.tecacet.games.sudoku.ChocoSudokuSolver;
import com.tecacet.games.sudoku.Sudoku;
import com.tecacet.games.sudoku.SudokuStrategy;
import com.tecacet.games.sudoku.io.ClasspathGameReader;
import com.tecacet.games.sudoku.io.GameReader;

import java.io.IOException;

import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class SudokuAssembler {

    private SudokuPanel panel;
    private JMenuBar bar;

    public void assemble() throws IOException {
        GameReader reader = new ClasspathGameReader();
        Sudoku game = new Sudoku();
        reader.read(game, "evil1.sud");
        SudokuStrategy player =
                new ChocoSudokuSolver(game);
        //new CombinedStrategy(game);
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
