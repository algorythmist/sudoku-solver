package com.tecacet.games.sudoku;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Stack;

public class BestCellStrategy implements SudokuStrategy {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    protected Sudoku game;
    private final Stack<Move> moves = new Stack<>();

    public BestCellStrategy(Sudoku game) {
        this.game = game;
    }

    @Override
    public void solve() {
        Move move;
        do {
            move = move();
        } while (move != null);
    }

    @Override
    public Move move() {
        if (game.isSolved()) {
            log.info("Victory!");
            return null;
        }
        Move move = getNextMove();
        log.debug("Move = {}", move);
        if (move != null) {
            playMove(move);
        } else {
            log.info("Alas! We lost");
        }
        return move;
    }

    protected void playMove(Move move) {
        game.setValue(move.getRow(), move.getColumn(), move.getValue());
        moves.push(move);
    }

    protected Move pop() {
        if (moves.isEmpty()) {
            return null;
        }
        Move move = undo();
        if (move.crossOut()) {
            log.debug("Undoing move {}", move);
            return move;
        }
        log.debug("Nothing available at {},{}. Popping again...",
                move.getRow(), +move.getColumn());
        return pop();

    }

    @Override
    public Move undo() {
        if (moves.isEmpty()) {
            return null;
        }
        Move move = moves.pop();
        game.setValue(move.getRow(), move.getColumn(), null);
        return move;
    }

    protected Move getNextMove() {
        Cell cell = findBestCell();
        if (cell == null) {
            return pop();
        }
        return new Move(cell, game.getValidValues(cell.getRow(),
                cell.getColumn()));
    }

    /**
     * Find a cell with minimal moves
     */
    protected Cell findBestCell() {
        Cell cell = null;
        int size = game.getSize();
        int bestLength = size + 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (game.getValue(i, j) != null) {
                    continue;
                }
                List<Integer> l = game.getValidValues(i, j);
                if (!l.isEmpty() && l.size() < bestLength) {
                    bestLength = l.size();
                    cell = new Cell(i, j);
                }
            }
        }
        return cell;
    }
}
