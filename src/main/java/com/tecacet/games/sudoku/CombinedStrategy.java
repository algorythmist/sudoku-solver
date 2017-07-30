package com.tecacet.games.sudoku;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class CombinedStrategy extends BestCellStrategy {

	public CombinedStrategy(Sudoku game) {
		super(game);
	}

	protected Move getNextMove() {
		Collection<Neighborhood> neighborhoods = game.getNeighborhoods();

		for (Neighborhood neighborhood : neighborhoods) {
			Map<Integer, Set<Cell>> values = neighborhood.getUnassignedValues();
			for (Integer i : values.keySet()) {
				Set<Cell> cells = values.get(i);
				if (cells.size() == 1) {
					Cell cell = cells.iterator().next();
					return new Move(cell, i);

				}
			}
		}
		return super.getNextMove();
	}

}
