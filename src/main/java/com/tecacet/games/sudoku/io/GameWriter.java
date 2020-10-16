package com.tecacet.games.sudoku.io;

import com.tecacet.games.sudoku.Sudoku;

import java.io.FileWriter;
import java.io.IOException;

public class GameWriter {

    public void write(Sudoku game, String filename) throws IOException {
        FileWriter fw = new FileWriter(filename);
        for (int i = 0; i < game.getSize(); i++) {
            StringBuilder line = new StringBuilder();
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
