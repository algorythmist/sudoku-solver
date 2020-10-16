package com.tecacet.games.sudoku;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.ArrayList;

public class MoveTest {

    @Test
    public void testCrossOut() {
        ArrayList<Integer> values = new ArrayList<>();
        values.add(1);
        values.add(3);
        values.add(4);
        Move m = new Move(new Cell(0, 0), values);
        assertEquals(1, m.getValue());
        assertTrue(m.crossOut());
        assertEquals(3, m.getValue());
        assertTrue(m.crossOut());
        assertEquals(4, m.getValue());
        assertFalse(m.crossOut());
    }

    @Test
    public void testToString() {
        ArrayList<Integer> values = new ArrayList<>();
        values.add(1);
        values.add(3);
        values.add(4);
        Move m = new Move(new Cell(2, 5), values);
        assertEquals("(3,6) = 1 [1, 3, 4]", m.toString());
    }
}
