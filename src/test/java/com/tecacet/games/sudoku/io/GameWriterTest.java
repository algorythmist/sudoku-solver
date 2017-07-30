package com.tecacet.games.sudoku.io;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import com.tecacet.games.sudoku.Sudoku;

public class GameWriterTest {

	@Test
	public void testWrite() throws IOException {
		String filename = "test.sud";
		GameWriter writer = new GameWriter();
		Sudoku game = new Sudoku();
		writer.write(game, filename);
		File file = new File(filename);
		assertTrue(file.exists());
		file.delete();
	}

}
