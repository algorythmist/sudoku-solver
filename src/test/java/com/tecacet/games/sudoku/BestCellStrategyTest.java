package com.tecacet.games.sudoku;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import java.util.ArrayList;

public class BestCellStrategyTest {

    @Test
    public void testFindBestCell() {
        Sudoku game = new Sudoku();
        game.setValue(0, 0, 1);
        game.setValue(0, 1, 3);
        game.setValue(1, 3, 2);
        BestCellStrategy player = new BestCellStrategy(game);
        Cell cell = player.findBestCell();
        assertEquals(0, cell.getRow());
        assertEquals(3, cell.getColumn());
    }

    @Test
    public void testGetNextMove() {
        Sudoku game = new Sudoku();
        game.setValue(0, 0, 1);
        game.setValue(0, 1, 3);
        game.setValue(1, 3, 2);
        BestCellStrategy player = new BestCellStrategy(game);
        Move move = player.getNextMove();
        assertEquals(0, move.getRow());
        assertEquals(3, move.getColumn());
    }

    @Test
    public void testUndo() {
        Sudoku game = new Sudoku();
        BestCellStrategy p = new BestCellStrategy(game);
        ArrayList<Integer> values = new ArrayList<>();
        values.add(1);
        values.add(3);
        values.add(4);
        Move m = new Move(new Cell(0, 0), values);
        p.playMove(m);
        assertEquals(1, game.getValue(0, 0).intValue());
        Move undo = p.undo();
        assertNull(game.getValue(0, 0));
        assertEquals(m.getValue(), undo.getValue());
        assertEquals(m.getColumn(), undo.getColumn());
        assertEquals(m.getRow(), undo.getRow());
    }

    @Test
    public void testPlayMove() {
        Sudoku game = new Sudoku();
        BestCellStrategy p = new BestCellStrategy(game);
        ArrayList<Integer> values = new ArrayList<>();
        values.add(1);
        values.add(3);
        values.add(4);
        Move m = new Move(new Cell(0, 0), values);
        p.playMove(m);
        assertEquals(1, game.getValue(0, 0).intValue());
    }

    @Test
    public void testPop() {
        Sudoku game = new Sudoku();
        BestCellStrategy p = new BestCellStrategy(game);
        ArrayList<Integer> values = new ArrayList<>();
        values.add(1);
        values.add(3);
        values.add(4);
        Move m = new Move(new Cell(0, 0), values);
        p.playMove(m);
        assertEquals(1, game.getValue(0, 0).intValue());
        Move popped = p.pop();
        assertNull(game.getValue(0, 0));
        assertEquals(3, popped.getValue());
        p.playMove(m);
        assertEquals(3, game.getValue(0, 0).intValue());
        popped = p.pop();
        assertNull(game.getValue(0, 0));
        assertEquals(4, popped.getValue());
        assertNull(p.pop());
    }

    @Test
    public void testMove() {
        Sudoku game = new Sudoku();
        game.setValue(0, 0, 1);
        game.setValue(0, 1, 2);
        game.setValue(2, 2, 2);
        game.setValue(2, 3, 4);
        game.setValue(3, 0, 2);
        game.setValue(3, 1, 4);

        SudokuStrategy p = new BestCellStrategy(game);
        p.move();

        assertEquals(3, game.getValue(0,3).intValue());
        p.move();
        assertEquals(5, game.getValue(0,4).intValue());
    }

}
