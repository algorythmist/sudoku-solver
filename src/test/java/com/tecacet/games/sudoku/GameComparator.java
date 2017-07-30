package com.tecacet.games.sudoku;

import java.util.Objects;

public class GameComparator {

	public static boolean equals(Sudoku game1, Sudoku game2) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (!Objects.equals(game1.getValue(i, j), game2.getValue(i, j))) {
					System.out.printf("Games differ at cell (%d,%d)\n", i, j);
					return false;
				}
			}
		}
		return true;
	}
}
