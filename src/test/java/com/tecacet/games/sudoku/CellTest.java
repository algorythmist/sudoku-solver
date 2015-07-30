package com.tecacet.games.sudoku;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CellTest  {

	@Test
	public void testHashCode() {
		Cell cell1 = new Cell(2, 3);
		Cell cell2 = new Cell(5, 1);
		assertFalse(cell1.hashCode() == cell2.hashCode());
		cell2 = new Cell(2, 3);
		assertEquals(cell1.hashCode(), cell2.hashCode());
	}

	@Test
	public void testEqualsObject() {
		Cell cell1 = new Cell(2, 3);
		Cell cell2 = new Cell(5, 1);
		assertFalse(cell1.equals(cell2));
		cell2 = new Cell(2, 3);
		assertTrue(cell1.equals(cell2));
	}

	@Test
	public void testToString() {
		Cell cell = new Cell(2, 3);
		assertEquals("(3,4)", cell.toString());
	}

}
