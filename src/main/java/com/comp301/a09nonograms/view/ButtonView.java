package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.controller.Controller;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ButtonView implements FXComponent {

    private final Controller controller;

    public ButtonView(Controller controller) {
        this.controller = controller;
    }

    @Override
    public Parent render() {
        HBox layout = new HBox();
        layout.setSpacing(5);

        // Clear Button
        Button clearbutton = new Button("Clear Puzzle");
        clearbutton.setOnAction(
                (ActionEvent event) -> {
                    controller.clearBoard();
                });
        layout.getChildren().add(clearbutton);

        // random button
        Button randbutton = new Button("Random Puzzle");
        randbutton.setOnAction(
                (ActionEvent event) -> {
                    controller.randPuzzle();
                });
        layout.getChildren().add(randbutton);

        // next button
        Button nextbutton = new Button("Next Puzzle");
        nextbutton.setOnAction(
                (ActionEvent event) -> {
                    controller.nextPuzzle();
                });
        layout.getChildren().add(nextbutton);

        // prev button
        Button prevbutton = new Button("Previous Puzzle");
        prevbutton.setOnAction(
                (ActionEvent event) -> {
                    controller.prevPuzzle();
                });

        layout.getChildren().add(prevbutton);
        layout.setAlignment(Pos.CENTER);

        return layout;
    }
}
