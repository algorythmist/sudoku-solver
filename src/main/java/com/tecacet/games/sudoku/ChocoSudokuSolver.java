package com.tecacet.games.sudoku;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.search.strategy.Search;
import org.chocosolver.solver.variables.IntVar;
import org.chocosolver.util.tools.ArrayUtils;

/**
 * Solve Sudoku using Choco constraint programming solver
 */
public class ChocoSudokuSolver implements SudokuStrategy {

	private final Sudoku game;
	
	public ChocoSudokuSolver(Sudoku game) {
		super();
		this.game = game;
	}

	@Override
	public void solve() {
		Model model = new Model("Sudoku");
		int n = 9;

		//row and column variables
		IntVar[][] rows = new IntVar[n][n];
		IntVar[][] cols = new IntVar[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (game.getValue(i, j) != null) {
                    //if value is populated it can only have the current value
                    rows[i][j] = model.intVar(game.getValue(i, j));
                } else {
                    //otherwise, it can take values from 1 to n
                    rows[i][j] = model.intVar("c_" + i + "_" + j, 1, n);
                }
                //same with columns
                cols[j][i] = rows[i][j];
            }
        }

        //Define variables for the 9 regions
        IntVar[][] regions = new IntVar[n][n];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    regions[j + k * 3][i] = rows[k * 3][i + j * 3];
                    regions[j + k * 3][i + 3] = rows[1 + k * 3][i + j * 3];
                    regions[j + k * 3][i + 6] = rows[2 + k * 3][i + j * 3];
                }
            }
        }

        //constraints
        for (int i = 0; i < n; i++) {
            model.allDifferent(rows[i]).post();  //row values should be all different
            model.allDifferent(cols[i]).post();  //column values should be all different
            model.allDifferent(regions[i]).post(); //region values should be all different
        }
        model.getSolver().setSearch(Search.minDomLBSearch(ArrayUtils.append(rows)));
        model.getSolver().findSolution();
        //assign the solution values to the game
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                game.setValue(i, j, rows[i][j].getValue());
            }
        }
	}

	@Override
	public Move move() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Move undo() {
		throw new UnsupportedOperationException();
	}

}
