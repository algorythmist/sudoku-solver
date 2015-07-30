package com.tecacet.games.sudoku.io;

import java.io.IOException;

import com.tecacet.games.sudoku.Sudoku;

public interface GameReader {

    void read(Sudoku game, String filename) throws IOException;

    
}