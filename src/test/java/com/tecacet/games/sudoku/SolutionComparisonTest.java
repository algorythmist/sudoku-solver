package com.tecacet.games.sudoku;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.tecacet.games.sudoku.io.ClasspathGameReader;
import com.tecacet.games.sudoku.io.GameReader;


public class SolutionComparisonTest {

	private final GameReader reader = new ClasspathGameReader();

	@Test
	public void tesBestCellStrategy() throws IOException {
		Sudoku game = new Sudoku();
		SudokuStrategy solver = new BestCellStrategy(game);
		testGame(game, "easy1", solver);
		
		game = new Sudoku();
		solver = new BestCellStrategy(game);
		testGame(game, "hard1", solver);	
	}

	@Test
	public void testCombinedStrategy() throws IOException {
		Sudoku game = new Sudoku();
		SudokuStrategy solver = new CombinedStrategy(game);
		testGame(game, "easy1", solver);
		
		game = new Sudoku();
		solver = new CombinedStrategy(game);
		testGame(game, "hard1", solver);	
	}
	
	@Test
	public void testChocoStrategy() throws IOException {
		Sudoku game = new Sudoku();
		SudokuStrategy solver = new ChocoSudokuSolver(game);
		testGame(game, "easy1", solver);
		
		game = new Sudoku();
		solver = new ChocoSudokuSolver(game);
		testGame(game, "hard1", solver);	
	}

	private void testGame(Sudoku game, String name, SudokuStrategy solver)
			throws IOException {
		
		// read unsolved game
		reader.read(game, name + ".sud");
		// read control
		Sudoku control = new Sudoku();
		reader.read(control, name + "_control.sud");
		solver.solve();
		Assert.assertTrue(GameComparator.equals(game, control));
	}

}
