package com.tecacet.games.sudoku.gui;

import java.util.ArrayList;
import java.util.List;

public class ListenerSupport {

    private final List<SudokuEventListener> listeners = new ArrayList<>();

    public void notifyListeners(SudokuEvent event) {
        for (SudokuEventListener l : listeners) {
            l.actionPerformed(event);
        }
    }

    public void addListener(SudokuEventListener listener) {
        listeners.add(listener);
    }
}
