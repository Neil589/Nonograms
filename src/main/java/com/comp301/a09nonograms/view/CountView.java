package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.controller.Controller;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class CountView implements FXComponent {
    private final Controller controller;

    public CountView(Controller controller) {
        this.controller = controller;
    }

    @Override
    public Parent render() {
        StackPane layout = new StackPane();
        // Label for puzzle number
        Label puzzlenolabel = new Label(makeLabelString());
        layout.getChildren().add(puzzlenolabel);
        return layout;
    }

    private String makeLabelString() {
        int index = controller.getPuzzleIndex() + 1;
        int count = controller.getPuzzleCount();
        String labelstring = "Puzzle number: " + index + " out of " + count;
        return labelstring;
    }
}
