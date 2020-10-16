package com.tecacet.games.sudoku.gui;

import java.awt.HeadlessException;
import java.io.IOException;

import javax.swing.JApplet;

public class SudokuApplet extends JApplet {

    public SudokuApplet() throws HeadlessException {
        super();
    }

    public void init() {
        SudokuAssembler assembler = new SudokuAssembler();
        try {
            assembler.assemble();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        setJMenuBar(assembler.getMenuBar());
        getContentPane().add(assembler.getMainPanel());
    }
}
