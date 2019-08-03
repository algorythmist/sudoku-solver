package com.tecacet.games.sudoku;

import org.chocosolver.solver.Solver;
import org.chocosolver.solver.constraints.IntConstraintFactory;
import org.chocosolver.solver.search.strategy.IntStrategyFactory;
import org.chocosolver.solver.variables.IntVar;
import org.chocosolver.solver.variables.VariableFactory;
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
		Solver solver = new Solver("Sudoku");
		int n = 9;
		IntVar[][] rows = new IntVar[n][n];
		IntVar[][] cols = new IntVar[n][n];
		IntVar[][] carres = new IntVar[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
            	
                if (game.getValue(i, j) != null) {
                    rows[i][j] = VariableFactory.fixed(game.getValue(i, j), solver);
                } else {
                    rows[i][j] = VariableFactory.enumerated("c_" + i + "_" + j, 1, n, solver);
                }
                cols[j][i] = rows[i][j];
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    carres[j + k * 3][i] = rows[k * 3][i + j * 3];
                    carres[j + k * 3][i + 3] = rows[1 + k * 3][i + j * 3];
                    carres[j + k * 3][i + 6] = rows[2 + k * 3][i + j * 3];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            solver.post(IntConstraintFactory.alldifferent(rows[i], "AC"));
            solver.post(IntConstraintFactory.alldifferent(cols[i], "AC"));
            solver.post(IntConstraintFactory.alldifferent(carres[i], "AC"));
        }
        solver.set(IntStrategyFactory.minDom_LB(ArrayUtils.append(rows)));
        solver.findSolution();
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
