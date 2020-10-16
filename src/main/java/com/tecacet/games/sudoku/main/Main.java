package com.tecacet.games.sudoku.main;

import com.tecacet.games.sudoku.gui.SudokuAssembler;

import java.io.IOException;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) throws IOException {

        SudokuAssembler assembler = new SudokuAssembler();
        assembler.assemble();
        JFrame f = new JFrame("Sudoku");
        f.setJMenuBar(assembler.getMenuBar());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(assembler.getMainPanel());
        f.pack();
        f.setVisible(true);
    }

}
