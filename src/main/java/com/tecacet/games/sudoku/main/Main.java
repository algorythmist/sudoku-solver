package com.tecacet.games.sudoku.main;

import java.io.IOException;

import javax.swing.JFrame;

import com.tecacet.games.sudoku.gui.SudokuAssembler;

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
