package com.comp301.a09nonograms.model;

public class CluesImpl implements Clues {
    private final int[][] rowClues;
    private final int[][] colClues;
    private int width;
    private int height;

    public CluesImpl(int[][] rowClues, int[][] colClues) {
        // Constructor code here
        if (rowClues == null || colClues == null) {
            throw new IllegalArgumentException();
        }
        this.colClues = colClues;
        this.rowClues = rowClues;
        this.width = width;
        this.height = height;
    }

    // the following are methods imported from the clues interface. All descriptions are given in the clues interface.
    @Override
    public int getWidth() {
        return colClues.length;
    }

    @Override
    public int getHeight() {
        return rowClues.length;
    }

    @Override
    public int[] getRowClues(int index) {
        return rowClues[index];
    }

    @Override
    public int[] getColClues(int index) {
        return colClues[index];
    }

    @Override
    public int getRowCluesLength() {
        return getRowClues(0).length;
    }

    @Override
    public int getColCluesLength() {
        return getColClues(0).length;
    }
}
