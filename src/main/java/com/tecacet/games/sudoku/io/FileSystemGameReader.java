package com.tecacet.games.sudoku.io;

import java.io.FileReader;
import java.io.IOException;

import com.tecacet.games.sudoku.Sudoku;

public class FileSystemGameReader extends BaseGameReader implements GameReader {

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.animism.games.sudoku.io.GameReader#read(org.animism.games.sudoku.
     * Sudoku, java.lang.String)
     */
    public void read(Sudoku game, String filename) throws IOException {
	super.read(game,new FileReader(filename));
	
    }
}
