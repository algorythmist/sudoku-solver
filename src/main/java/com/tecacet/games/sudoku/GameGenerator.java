package com.tecacet.games.sudoku;

import java.util.LinkedList;

//TODO generate valid Sudoku games
public class GameGenerator {

    private static final int[] VALUES = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    private final Sudoku game = new Sudoku();

    public static void main(String[] args) {
        GameGenerator generator = new GameGenerator();
        generator.generateSeedGame();
        System.out.println(generator.game);

    }

    public void generateSeedGame() {
        LinkedList<Integer> values = new LinkedList<>();
        for (int i : VALUES) {
            values.add(i);
        }
        int size = game.getSize();

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < size; col++) {
                game.setValue(row, col, values.get(col));
            }
            rotateleft(values, 3);
        }
        rotateleft(values, 1);
        for (int row = 3; row < 6; row++) {
            for (int col = 0; col < size; col++) {
                game.setValue(row, col, values.get(col));
            }
            rotateleft(values, 3);
        }
        rotateleft(values, 1);
        for (int row = 6; row < 9; row++) {
            for (int col = 0; col < size; col++) {
                game.setValue(row, col, values.get(col));
            }
            rotateleft(values, 3);
        }
    }

    private void rotateleft(LinkedList<?> list, int times) {
        for (int i = 0; i < times; i++) {
            rotateleft(list);
        }
    }

    private <T> void rotateleft(LinkedList<T> list) {
        list.add(list.removeFirst());
    }

}
