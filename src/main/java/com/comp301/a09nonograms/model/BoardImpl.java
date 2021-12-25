package com.comp301.a09nonograms.model;

public class BoardImpl implements Board {

    private final int[][] twoD_arr;
    private final int width;
    private final int height;

    public BoardImpl(int width, int height) {
        this.twoD_arr = new int[height + 3][width + 3];
        this.height = height;
        this.width = width;
    }

    // the following are methods implemented from the board interface. All descriptions are given in the board interface.
    @Override
    public boolean isShaded(int row, int col) {
        return twoD_arr[row][col] == 1;
    }

    @Override
    public boolean isEliminated(int row, int col) {
        return twoD_arr[row][col] == 2;
    }

    @Override
    public boolean isSpace(int row, int col) {
        return twoD_arr[row][col] == 0;
    }

    @Override
    public void toggleCellShaded(int row, int col) {
        if (isShaded(row, col)) {
            twoD_arr[row][col] = 0;
        } else {
            twoD_arr[row][col] = 1;
        }
    }

    @Override
    public void toggleCellEliminated(int row, int col) {
        if (isEliminated(row, col)) {
            twoD_arr[row][col] = 0;
        } else {
            twoD_arr[row][col] = 2;
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < twoD_arr.length; i++)
            for (int j = 0; j < twoD_arr[i].length; j++) twoD_arr[i][j] = 0;
    }
}
