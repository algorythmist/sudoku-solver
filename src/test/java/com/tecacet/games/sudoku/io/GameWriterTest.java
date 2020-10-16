package com.tecacet.games.sudoku.io;

import static org.junit.Assert.assertTrue;

import com.tecacet.games.sudoku.Sudoku;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

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
