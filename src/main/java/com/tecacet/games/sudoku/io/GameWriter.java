package com.tecacet.games.sudoku.io;

import java.io.FileWriter;
import java.io.IOException;

import com.tecacet.games.sudoku.Sudoku;

public class GameWriter {

    public void write(Sudoku game, String filename) throws IOException {
        FileWriter fw = new FileWriter(filename);
        for (int i = 0; i < game.getSize(); i++) {
            StringBuffer line = new StringBuffer();
            for (int j = 0; j < game.getSize(); j++) {
                Integer value = game.getValue(i, j);
                if (value == null) {
                    line.append("x ");
                } else {
                    line.append(value + " ");
                }
                
            }
            line.append("\n");
            fw.write(line.toString());
        }
        fw.flush();
        fw.close();
    }
}
