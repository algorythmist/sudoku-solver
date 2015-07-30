package com.tecacet.games.sudoku;

public class GameComparator {

	public static boolean equals(Sudoku game1, Sudoku game2) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if ( game1.getValue(i, j ) != game2.getValue(i, j)) {
					return false;
				}
			}
		}
		return true;
	}
}
