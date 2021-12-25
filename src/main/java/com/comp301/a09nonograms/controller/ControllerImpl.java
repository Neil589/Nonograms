package com.comp301.a09nonograms.controller;

import com.comp301.a09nonograms.model.Clues;
import com.comp301.a09nonograms.model.Model;

public class ControllerImpl implements Controller {
    private final Model model;

    public ControllerImpl(Model model) {
        // Constructor code goes here
        this.model = model;
    }

    //method details in Controller interface
    @Override
    public Clues getClues() {
        return model;
    }

    @Override
    public boolean isSolved() {
        return model.isSolved();
    }

    @Override
    public boolean isShaded(int row, int col) {
        return model.isShaded(row, col);
    }

    @Override
    public boolean isEliminated(int row, int col) {
        return model.isEliminated(row, col);
    }

    @Override
    public void toggleShaded(int row, int col) {
        model.toggleCellShaded(row, col);
    }

    @Override
    public void toggleEliminated(int row, int col) {
        model.toggleCellEliminated(row, col);
    }

    @Override
    public void nextPuzzle() {
        model.clear();
        if (getPuzzleIndex() == model.getPuzzleCount() - 1) {
            return;
        } else {
            model.setPuzzleIndex(model.getPuzzleIndex() + 1); //increment index
        }
    }

    @Override
    public void prevPuzzle() {
        model.clear();
        if (getPuzzleIndex() == 0) {
            return;
        } else {
            model.setPuzzleIndex(model.getPuzzleIndex() - 1); //decrement index
        }
    }

    @Override
    public void randPuzzle() {
        int currindex = model.getPuzzleIndex();
        int random = (int) (Math.random() * model.getPuzzleCount());
        while (random == currindex) { //to ensure that the random puzzle is not the same as the previous one.
            random = (int) (Math.random() * model.getPuzzleCount());
        }
        model.setPuzzleIndex(random);
    }

    @Override
    public void clearBoard() {
        model.clear();
    }

    @Override
    public int getPuzzleIndex() {
        return model.getPuzzleIndex();
    }

    @Override
    public int getPuzzleCount() {
        return model.getPuzzleCount();
    }
}
