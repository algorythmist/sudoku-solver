package com.tecacet.games.sudoku.io;

import com.tecacet.games.sudoku.Sudoku;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ClasspathGameReader extends BaseGameReader implements GameReader {

    @Override
    public void read(Sudoku game, String filename) throws IOException {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(filename);
        if (is == null) {
            throw new FileNotFoundException("File not found");
        }
        super.read(game, new InputStreamReader(is));
    }

}
