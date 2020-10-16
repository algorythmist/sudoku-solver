package com.tecacet.games.sudoku;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.tecacet.games.sudoku.io.ClasspathGameReader;
import com.tecacet.games.sudoku.io.GameReader;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class SudokuTest {

    @Test
    public void testGetSet() {
        Sudoku game = new Sudoku();
        game.setValue(0, 1, 2);
        assertNull(game.getValue(0, 0));
        assertEquals(2, game.getValue(0, 1).intValue());
    }

    @Test
    public void testIsValidValue() throws IOException {
        Sudoku game = new Sudoku();
        game.setValue(0, 0, 2);
        game.setValue(0, 1, 3);
        assertFalse(game.isValidValue(0, 2, 2));
        assertTrue(game.isValidValue(0, 2, 1));
        game.setValue(1, 0, 1);
        assertFalse(game.isValidValue(2, 0, 2));

        // test with harder game
        game = new Sudoku();
        GameReader r = new ClasspathGameReader();
        r.read(game, "easy1.sud");
        assertTrue(game.isValidValue(0,2,1));
        assertFalse(game.isValidValue(0,2,2));
    }

    @Test
    public void testGetValidValues() {
        Sudoku game = new Sudoku();
        game.setValue(0, 0, 2);
        game.setValue(0, 1, 3);
        List<Integer> values = game.getValidValues(0, 2);
        assertEquals(7, values.size());
        assertEquals(1, values.get(0).intValue());
        assertEquals(4, values.get(1).intValue());
        values = game.getValidValues(1, 1);
        assertEquals(7, values.size());
    }

    @Test
    public void testCellsFilled() {
        Sudoku game = new Sudoku();
        game.setValue(0, 0, 2);
        game.setValue(0, 1, 3);
        assertEquals(2, game.cellsFilled());
        game.setValue(0, 0, null);
        assertEquals(1, game.cellsFilled());
    }

}
