package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.controller.Controller;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class SolveView implements FXComponent {

    private final Controller controller;

    public SolveView(Controller controller) {
        this.controller = controller;
    }

    @Override
    public Parent render() {
        HBox layout = new HBox();
        //checks the solved status of the puzzle
        Label instlabel2 = new Label("Is the puzzle solved: ");
        Label instlabel3;
        //if the puzzle is solved a sucess message is output
        if (controller.isSolved()) {
            instlabel3 = new Label(" Yes! Great Job!");
            instlabel3.setStyle("-fx-text-fill: #00FF00");
        } else {
            //if the puzzle is not solved a failure message is output
            instlabel3 = new Label(" No. Keep Trying");
            instlabel3.setStyle("-fx-text-fill: #ff0000");
        }
        layout.getChildren().add(instlabel2);

        layout.getChildren().add(instlabel3);
        layout.setAlignment(Pos.CENTER);
        return layout;
    }
}
