package com.tecacet.games.sudoku;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * The Sudoku board as an array of cells together with neoghborhood information
 * 
 */
public class Sudoku {

    private static final int NEIGHBORHOOD_SIZE = 3;

    private Neighborhood[][] neighborhoods;
    private List<Neighborhood> listOfNeighborhoods;
    private Integer[][] cells;
    private int size = NEIGHBORHOOD_SIZE * NEIGHBORHOOD_SIZE;
    private int cellsFilled = 0;

    public Sudoku() {
        cells = new Integer[size][size];
        listOfNeighborhoods = new ArrayList<Neighborhood>();
        neighborhoods = new Neighborhood[NEIGHBORHOOD_SIZE][NEIGHBORHOOD_SIZE];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                neighborhoods[i][j] = new Neighborhood(this, i * 3, j * 3);
                listOfNeighborhoods.add(neighborhoods[i][j]);
            }
        }
    }

    public void setValue(int row, int col, Integer value) {
        if (cells[row][col] == null && value != null) {
            cellsFilled++;
        } else if (cells[row][col] != null && value == null) {
            cellsFilled--;
        }
        int r = row / 3;
        int c = col / 3;
        if (value != null) {
            neighborhoods[r][c].addValue(value.intValue());
        } else {
            neighborhoods[r][c].removeValue(cells[row][col]);
        }
        cells[row][col] = value;

    }

    public int getSize() {
        return size;
    }

    public void setValue(int row, int col, int value) {
        setValue(row, col, new Integer(value));
    }

    public Integer getValue(int row, int col) {
        return cells[row][col];
    }

    public List<Integer> getValidValues(int row, int col) {
        List<Integer> values = new ArrayList<Integer>();
        for (int i = 1; i <= size; i++) {
            if (isValidValue(row, col, i)) {
                values.add(i);
            }
        }
        return values;
    }

    public boolean isSolved() {
        return (cellsFilled == size * size);
    }

    int cellsFilled() {
        return cellsFilled;
    }

    boolean isValidValue(int row, int col, int value) {
        for (int i = 0; i < size; i++) {
            if (i != col && cells[row][i] != null && cells[row][i] == value) {
                return false;
            }
            if (i != row && cells[i][col] != null && cells[i][col] == value) {
                return false;
            }
        }
        // find neighborhood
        int r = row / 3;
        int c = col / 3;
        return !(neighborhoods[r][c].contains(value));
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j] = null;
            }
        }
        listOfNeighborhoods.clear();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                neighborhoods[i][j] = new Neighborhood(this, i * 3, j * 3);

            }
        }
        cellsFilled = 0;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb.append(cells[i][j] == null ? "x " : cells[i][j] + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public Collection<Neighborhood> getNeighborhoods() {
        return listOfNeighborhoods;
    }

}
