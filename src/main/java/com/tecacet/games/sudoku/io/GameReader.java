package com.tecacet.games.sudoku.io;

import com.tecacet.games.sudoku.Sudoku;

import java.io.IOException;

public interface GameReader {

    void read(Sudoku game, String filename) throws IOException;


}