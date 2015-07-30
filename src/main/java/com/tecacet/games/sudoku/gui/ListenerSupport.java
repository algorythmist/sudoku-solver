package com.tecacet.games.sudoku.gui;

import java.util.ArrayList;
import java.util.List;

public class ListenerSupport {

	private List<SudokuEventListener> listeners = new ArrayList<SudokuEventListener>();

	public void notifyListeners(SudokuEvent event) {
		for (SudokuEventListener l : listeners) {
			l.actionPerformed(event);
		}
	}

	public void addListener(SudokuEventListener listener) {
		listeners.add(listener);
	}
}
