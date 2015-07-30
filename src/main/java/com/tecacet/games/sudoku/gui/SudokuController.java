package com.tecacet.games.sudoku.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import com.tecacet.games.sudoku.Cell;
import com.tecacet.games.sudoku.Sudoku;
import com.tecacet.games.sudoku.SudokuStrategy;
import com.tecacet.games.sudoku.io.GameReader;
import com.tecacet.games.sudoku.io.GameWriter;

public class SudokuController implements ActionListener, SudokuEventListener {

	public static final String SOLVE_ACTION = "SOLVE";
	public static final String UNDO_ACTION = "UNDO";
	public static final String CLEAR_ACTION = "CLEAR";
	public static final String MOVE_ACTION = "MOVE";
	public static final String SELECT_ACTION = "SELECT";

	private Sudoku game;
	private SudokuStrategy player;
	private SudokuView view;
	private GameWriter writer = new GameWriter();

	public SudokuController(Sudoku game, SudokuStrategy player) {
		this.game = game;
		this.player = player;

	}

	public void setView(SudokuView view) {
		this.view = view;
	}

	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (MOVE_ACTION.equals(command)) {
			player.move();
			view.refresh();
		} else if (CLEAR_ACTION.equals(command)) {
			game.clear();
			view.clear();
		} else if (UNDO_ACTION.equals(command)) {
			player.undo();
			view.refresh();
		} else if (SOLVE_ACTION.equals(command)) {
			player.solve();
			view.refresh();
		}
	}

	public void actionPerformed(SudokuEvent event) {
		Cell cell = event.getCell();
		game.setValue(cell.getRow(), cell.getColumn(), event.getValue());
	}

	public void loadGame(String name, GameReader reader) {
		game.clear();
		try {
			reader.read(game, name);
		} catch (IOException e) {
			// TODO
			JOptionPane.showMessageDialog(view.getComponent(), e.toString());
		}
		view.refresh();
	}

	public void saveGame(String name) {
		try {
			writer.write(game, name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(view.getComponent(), e.toString());
		}
	}
}
