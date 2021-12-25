package com.comp301.a09nonograms.model;

import java.util.ArrayList;
import java.util.List;

public class ModelImpl implements Model {
    private final List<Clues> clues;
    private final List<ModelObserver> modelObservers;
    private int active = 0; // index for puzzle#
    private Board board;
    private Clues clue;

    public ModelImpl(List<Clues> clues) {
        if (clues == null) {
            throw new IllegalArgumentException();
        }
        this.board = new BoardImpl(clues.get(active).getHeight(), clues.get(active).getWidth()); //creating a new board with height and width
        this.clues = clues;
        this.modelObservers = new ArrayList<>(); //new array list for observers
    }

    // made an enum for 3 states 0 - empty 1- shaded 2-eliminated

    @Override
    //Checks if cell is shaded
    public boolean isShaded(int row, int col) {
        if (row >= clues.get(active).getHeight()
                || col >= clues.get(active).getWidth()
                || col < 0
                || row < 0) {
            throw new RuntimeException();
        }
        return board.isShaded(row, col);
    }

    @Override
    //checks if shell is eliminated
    public boolean isEliminated(int row, int col) {
        if (row >= clues.get(active).getHeight()
                || col >= clues.get(active).getWidth()
                || col < 0
                || row < 0) {
            throw new RuntimeException();
        }

        return board.isEliminated(row, col);
    }

    @Override
    //checks if cell has a space or not
    public boolean isSpace(int row, int col) {
        if (row >= clues.get(active).getHeight()
                || col >= clues.get(active).getWidth()
                || col < 0
                || row < 0) {
            throw new RuntimeException();
        }
        return board.isSpace(row, col);
    }

    @Override
    //toggles a cell to be shaded
    public void toggleCellShaded(int row, int col) {
        if (row >= clues.get(active).getHeight()
                || col >= clues.get(active).getWidth()
                || col < 0
                || row < 0) {
            throw new RuntimeException();
        }
        board.toggleCellShaded(row, col);
        // updates observers
        for (ModelObserver obs : modelObservers) {
            obs.update(this);
        }
    }

    @Override
    //toggles a cell to be eliminated
    public void toggleCellEliminated(int row, int col) {
        if (row >= clues.get(active).getHeight()
                || col >= clues.get(active).getWidth()
                || col < 0
                || row < 0) {
            throw new RuntimeException();
        }
        board.toggleCellEliminated(row, col);
        // updates observers
        for (ModelObserver obs : modelObservers) {
            obs.update(this);
        }
    }

    @Override
    //clears a filled out cell
    public void clear() {
        board.clear();
        // updates observers
        for (ModelObserver obs : modelObservers) {
            obs.update(this);
        }
    }

    @Override
    //returns board width
    public int getWidth() {
        return clues.get(active).getWidth();
    }

    @Override
    //returns board height
    public int getHeight() {
        return clues.get(active).getHeight();
    }

    @Override
    //returns board row clues
    public int[] getRowClues(int index) {
        return clues.get(active).getRowClues(index);
    }

    @Override
    //returns board column clues
    public int[] getColClues(int index) {
        return clues.get(active).getColClues(index);
    }

    @Override
    //returns the row clues length
    public int getRowCluesLength() {
        return clues.get(active).getRowCluesLength();
    }

    @Override
    //returns the column clues length
    public int getColCluesLength() {
        return clues.get(active).getColCluesLength();
    }

    @Override
    //returns the total number of puzzles in a library
    public int getPuzzleCount() {
        return clues.size();
    }

    @Override
    //returns the current puzzle number in a library
    public int getPuzzleIndex() {
        return active;
    }

    @Override
    //setter method to change the current puzzle number/index
    public void setPuzzleIndex(int index) {
        if (index < 0 || index >= getPuzzleCount()) {
            throw new IllegalArgumentException();
        }
        active = index;
        // updates observers
        board = new BoardImpl(clues.get(active).getWidth(), clues.get(active).getHeight());
        for (ModelObserver obs : modelObservers) {
            obs.update(this);
        }
    }

    @Override
    //adds an obsever to the observer list
    public void addObserver(ModelObserver observer) {
        modelObservers.add(observer);
    }

    @Override
    //removes an obsever to the observer list
    public void removeObserver(ModelObserver observer) {
        modelObservers.remove(observer);
    }

    @Override
    //checks if the puzzle is solved or not. i.e. all the correct cells are shaded.
    public boolean isSolved() {
        for (int i = getWidth() - 1; i >= 0; i--) {
            boolean flagC = false;
            int c = getColCluesLength() - 1;

            for (int j = getHeight() - 1; j >= 0; j--) {
                if (isShaded(j, i)) {
                    flagC = true;
                } else if (c != 0 && flagC) {
                    c--;
                    flagC = false;
                }
            }
        }
    }
