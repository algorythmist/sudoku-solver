package com.tecacet.games.sudoku;

import java.io.IOException;

import junit.framework.TestCase;

import com.tecacet.games.sudoku.io.ClasspathGameReader;
import com.tecacet.games.sudoku.io.GameReader;

public class CombinedStrategyTest extends TestCase {

    public void testMove() throws IOException {
        GameReader reader = new ClasspathGameReader();
        Sudoku game = new Sudoku();
        reader.read(game, "games/easy1.sud");
        System.out.println(game.toString());
        CombinedStrategy player = new CombinedStrategy(game);
        Move move = player.getNextMove();
        assertEquals(0, move.getRow());
        assertEquals(2, move.getColumn());
        assertEquals(1, move.getValue());
    }

    public void testSolve() throws IOException {
        Sudoku game = new Sudoku();
        BestCellStrategy p = new BestCellStrategy(game);
        GameReader r = new ClasspathGameReader();
        String filename = "games/hard1.sud";
        r.read(game, filename);
        System.out.println(game);
        p.solve();
        System.out.println(game);

    }

}
