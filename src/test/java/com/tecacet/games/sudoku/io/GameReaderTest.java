package com.tecacet.games.sudoku.io;

import java.io.IOException;

import junit.framework.TestCase;

import com.tecacet.games.sudoku.Sudoku;

public class GameReaderTest extends TestCase {

	public void testRead() throws IOException {
		Sudoku game = new Sudoku();
		GameReader r = new ClasspathGameReader();
		r.read(game,"sample2.sud");
		assertNull(game.getValue(0,0));
		assertEquals(8,game.getValue(0,3).intValue());
		assertEquals(9,game.getValue(8,3).intValue());
	}
}
