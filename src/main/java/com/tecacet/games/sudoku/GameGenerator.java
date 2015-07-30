package com.tecacet.games.sudoku;

import java.util.LinkedList;
import java.util.Random;

//TODO generate valid Sudoku games
public class GameGenerator {

    private static final int[] VALUES = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    private Sudoku game = new Sudoku();
    Random generator = new Random();

    public void generateSeedGame() {
        LinkedList<Integer> values = new LinkedList<Integer>();
        for (int i : VALUES) {
            values.add(i);
        }
        int size = game.getSize();

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < size; col++) {
                game.setValue(row, col, values.get(col));
            }
            rotateleft(values,3);
        }
        rotateleft(values,1);
        for (int row = 3; row < 6; row++) {
            for (int col = 0; col < size; col++) {
                game.setValue(row, col, values.get(col));
            }
            rotateleft(values,3);
        }
        rotateleft(values,1);
        for (int row = 6; row < 9; row++) {
            for (int col = 0; col < size; col++) {
                game.setValue(row, col, values.get(col));
            }
            rotateleft(values,3);
        }
    }

    private void rotateleft(LinkedList<?> list, int times) {
        for (int i = 0; i < times; i++) {
            rotateleft(list);
        }
    }

    private void rotateleft(LinkedList list) {
        list.add(list.removeFirst());
    }

//    private void setValidValue(int i, int j, Random r) throws UnsolvableGameException {
//        for (int tries = 0; tries < 10; tries++) {
//            int value = r.nextInt(game.getSize()) + 1;
//            if (game.isValidValue(i, j, value)) {
//                game.setValue(i, j, value);
//                return;
//            }
//        }
//        throw new UnsolvableGameException();
//    }

    public static void main(String[] args) {
        GameGenerator generator = new GameGenerator();
        generator.generateSeedGame();
        System.out.println(generator.game);

    }

}
