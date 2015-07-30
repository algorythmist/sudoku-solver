package com.tecacet.games.sudoku;

import java.io.IOException;
import java.util.ArrayList;

import junit.framework.TestCase;

import com.tecacet.games.sudoku.io.ClasspathGameReader;
import com.tecacet.games.sudoku.io.GameReader;

public class BestCellStrategyTest extends TestCase {

	public void testFindBestCell() {
		Sudoku game = new Sudoku();
		game.setValue(0, 0, 1);
		game.setValue(0, 1, 3);
		game.setValue(1, 3, 2);
		BestCellStrategy player = new BestCellStrategy(game);
		Cell cell = player.findBestCell();
		assertEquals(0, cell.getRow());
		assertEquals(3, cell.getColumn());
	}

	public void testGetNextMove() {
		Sudoku game = new Sudoku();
		game.setValue(0, 0, 1);
		game.setValue(0, 1, 3);
		game.setValue(1, 3, 2);
		BestCellStrategy player = new BestCellStrategy(game);
		Move move = player.getNextMove();
		assertEquals(0, move.getRow());
		assertEquals(3, move.getColumn());
	}

	public void testUndo() {
		Sudoku game = new Sudoku();
		BestCellStrategy p = new BestCellStrategy(game);
		ArrayList<Integer> values = new ArrayList<Integer>();
		values.add(new Integer(1));
		values.add(new Integer(3));
		values.add(new Integer(4));
		Move m = new Move(new Cell(0, 0), values);
		p.playMove(m);
		assertEquals(1, game.getValue(0, 0).intValue());
		Move undo = p.undo();
		assertNull(game.getValue(0, 0));
		assertEquals(m.getValue(), undo.getValue());
		assertEquals(m.getColumn(), undo.getColumn());
		assertEquals(m.getRow(), undo.getRow());
	}

	public void testPlayMove() {
		Sudoku game = new Sudoku();
		BestCellStrategy p = new BestCellStrategy(game);
		ArrayList<Integer> values = new ArrayList<Integer>();
		values.add(new Integer(1));
		values.add(new Integer(3));
		values.add(new Integer(4));
		Move m = new Move(new Cell(0, 0), values);
		p.playMove(m);
		assertEquals(1, game.getValue(0, 0).intValue());
	}

	public void testPop() {
		Sudoku game = new Sudoku();
		BestCellStrategy p = new BestCellStrategy(game);
		ArrayList<Integer> values = new ArrayList<Integer>();
		values.add(new Integer(1));
		values.add(new Integer(3));
		values.add(new Integer(4));
		Move m = new Move(new Cell(0, 0), values);
		p.playMove(m);
		assertEquals(1, game.getValue(0, 0).intValue());
		Move popped = p.pop();
		assertNull(game.getValue(0, 0));
		assertEquals(3, popped.getValue());
		p.playMove(m);
		assertEquals(3, game.getValue(0, 0).intValue());
		popped = p.pop();
		assertNull(game.getValue(0, 0));
		assertEquals(4, popped.getValue());
		assertNull(p.pop());
	}

	public void testMove() {
		Sudoku game = new Sudoku();
		game.setValue(0, 0, 1);
		game.setValue(0, 1, 2);
		game.setValue(2, 2, 2);
		game.setValue(2, 3, 4);
		game.setValue(3, 0, 2);
		game.setValue(3, 1, 4);
		// TODO test something
		System.out.println(game.toString());
		SudokuStrategy p = new BestCellStrategy(game);
		p.move();
		System.out.println(game.toString());
		p.move();
		System.out.println(game.toString());
	}

	// public void testHardGame() throws IOException {
	// Sudoku game = new Sudoku();
	// GameReader r = new GameReader();
	// r.read(game,"games/sample1.txt");
	// SudokuPlayer p = new SudokuPlayer(game);
	// // p.solve();
	// for (int i=0;i<50;i++) {
	// Move m = p.move();
	// }
	// Move m = p.move();
	// }

	public void testSolve() throws IOException {
		Sudoku game = new Sudoku();
		BestCellStrategy p = new BestCellStrategy(game);
		GameReader r = new ClasspathGameReader();
		r.read(game, "easy1.sud");
		System.out.println(game);
		p.solve();
		System.out.println(game);

	}
}
