package com.tecacet.games.sudoku;

import java.io.IOException;
import java.util.List;

import junit.framework.TestCase;

import com.tecacet.games.sudoku.io.ClasspathGameReader;
import com.tecacet.games.sudoku.io.GameReader;

public class SudokuTest extends TestCase {

	public void testGetSet() {
		Sudoku game = new Sudoku();
		game.setValue(0,1,2);
		assertNull(game.getValue(0,0));
		assertEquals(2,game.getValue(0,1).intValue());
	}
	
	public void testIsValidValue() throws IOException {
		Sudoku game = new Sudoku();
		game.setValue(0,0,2);
		game.setValue(0,1,3);
		assertFalse(game.isValidValue(0,2,2));
		assertTrue(game.isValidValue(0,2,1));
		game.setValue(1,0,1);
		assertFalse(game.isValidValue(2,0,2));
		
		// test with hard game
		game = new Sudoku();
		GameReader r = new ClasspathGameReader();
		r.read(game,"games/easy1.sud");
		//TODO
//		assertTrue(game.isValidValue(0,6,5));
//		assertFalse(game.isValidValue(0,6,6));
	}
	
	public void testGetValidValues() {
		Sudoku game = new Sudoku();
		game.setValue(0,0,2);
		game.setValue(0,1,3);
		List<Integer> l = game.getValidValues(0,2);
		assertEquals(7,l.size());
		assertEquals(new Integer(1),l.get(0));
		assertEquals(new Integer(4),l.get(1));
		l = game.getValidValues(1,1);
		assertEquals(7,l.size());
	}
	
	public void testCellsFilled() {
		Sudoku game = new Sudoku();
		game.setValue(0,0,2);
		game.setValue(0,1,3);
		assertEquals(2,game.cellsFilled());
		game.setValue(0,0,null);
		assertEquals(1,game.cellsFilled());
	}
	
	
	
}
