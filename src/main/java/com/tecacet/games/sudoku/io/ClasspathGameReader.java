package com.tecacet.games.sudoku.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.tecacet.games.sudoku.Sudoku;

public class ClasspathGameReader extends BaseGameReader implements GameReader {

    @Override
    public void read(Sudoku game, String filename) throws IOException {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(filename);
        super.read(game, new InputStreamReader(is));
    }

}
