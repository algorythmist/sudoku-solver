package com.tecacet.games.sudoku;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import com.tecacet.games.sudoku.io.ClasspathGameReader;
import com.tecacet.games.sudoku.io.GameReader;

public class CombinedStrategyTest {

	@Test
	public void testMove() throws IOException {
		GameReader reader = new ClasspathGameReader();
		Sudoku game = new Sudoku();
		reader.read(game, "easy1.sud");
		System.out.println(game.toString());
		CombinedStrategy player = new CombinedStrategy(game);
		Move move = player.getNextMove();
		assertEquals(0, move.getRow());
		assertEquals(2, move.getColumn());
		assertEquals(1, move.getValue());
	}

}
