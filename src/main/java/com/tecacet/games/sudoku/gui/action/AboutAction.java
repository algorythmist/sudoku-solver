package com.tecacet.games.sudoku.gui.action;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class AboutAction extends AbstractAction {

    private Component parent;
    
    private final static String MESSAGE = 
        "Fast Sudoku Game Solver\n\n"+
        "Developed by Dimitri Papaioannou\n\n"+
        "This program uses a combination of three strategies to solve Sudoku problems:\n" +
        "1 - Keep a list of valid cells for every unfilled value in each quadrant\n" +
        "2 - Keep a list of valid values for each cell on the board\n" +
        "3 - If the next move cannot be determined uniquely, keep a stack of moves and undo them if the game fails";
    
    public AboutAction(Component parent) {
        super("About");
        this.parent = parent;
    }
    
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(parent, MESSAGE); 
    }

}
