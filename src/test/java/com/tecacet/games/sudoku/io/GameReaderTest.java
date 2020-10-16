package com.tecacet.games.sudoku.io;

import com.tecacet.games.sudoku.Sudoku;

import junit.framework.TestCase;

import java.io.IOException;

public class GameReaderTest extends TestCase {

    public void testRead() throws IOException {
        Sudoku game = new Sudoku();
        GameReader r = new ClasspathGameReader();
        r.read(game, "sample2.sud");
        assertNull(game.getValue(0, 0));
        assertEquals(8, game.getValue(0, 3).intValue());
        assertEquals(9, game.getValue(8, 3).intValue());
    }
}
