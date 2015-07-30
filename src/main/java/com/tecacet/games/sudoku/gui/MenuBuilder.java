package com.tecacet.games.sudoku.gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.tecacet.games.sudoku.gui.action.AboutAction;
import com.tecacet.games.sudoku.gui.action.LoadGameAction;
import com.tecacet.games.sudoku.gui.action.SaveGameAction;
import com.tecacet.games.sudoku.io.ClasspathGameReader;
import com.tecacet.games.sudoku.io.GameReader;

public class MenuBuilder {

	private static final String[] GAMES = { "easy1.sud", "medium1.sud",
			"medium2.sud", "hard1.sud", "evil1.sud" };

	public static JMenuBar getMenuBar(final SudokuController controller,
			Component parent) {
		LoadGameAction loadGameAction = new LoadGameAction(controller, parent);
		SaveGameAction saveGameAction = new SaveGameAction(controller, parent);
		AboutAction aboutAction = new AboutAction(parent);
		final GameReader reader = new ClasspathGameReader();
		JMenu fileMenu = new JMenu("File");

		JMenuItem load = new JMenuItem(loadGameAction);
		fileMenu.add(load);
		JMenuItem save = new JMenuItem(saveGameAction);
		fileMenu.add(save);

		JMenu gameMenu = new JMenu("Games");
		for (final String name : GAMES) {
			JMenuItem item = new JMenuItem(name);
			item.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					controller.loadGame(name, reader);
				}

			});
			gameMenu.add(item);
		}

		JMenu helpMenu = new JMenu("Help");

		JMenuItem about = new JMenuItem(aboutAction);
		helpMenu.add(about);

		JMenuBar bar = new JMenuBar();
		bar.add(fileMenu);
		bar.add(gameMenu);
		bar.add(helpMenu);
		return bar;
	}
}
