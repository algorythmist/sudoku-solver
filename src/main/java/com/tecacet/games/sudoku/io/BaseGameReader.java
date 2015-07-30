package com.tecacet.games.sudoku.io;

import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;
import java.util.StringTokenizer;

import com.tecacet.games.sudoku.Sudoku;

public class BaseGameReader {

    public void read(Sudoku game, Reader reader) throws IOException {
	LineNumberReader lineReader = new LineNumberReader(reader);
	for (int i = 0; i < game.getSize(); i++) {
	    String line = lineReader.readLine();
	    StringTokenizer st = new StringTokenizer(line);
	    for (int j = 0; j < game.getSize(); j++) {
		try {
		    int value = Integer.parseInt(st.nextToken());
		    game.setValue(i, j, value);
		} catch (NumberFormatException pe) {
		    // means there's an x
		}
	    }
	}
    }
}
