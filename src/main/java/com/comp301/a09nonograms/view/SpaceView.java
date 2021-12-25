package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.controller.Controller;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class SpaceView implements FXComponent {

    private final Controller controller;

    public SpaceView(Controller controller) {
        this.controller = controller;
    }

    @Override
    public Parent render() {
        StackPane layout = new StackPane();

        // Creates an artificial stack pane to create a space
        Label instlabel2 = new Label();
        layout.getChildren().add(instlabel2);
        return layout;
    }
}
