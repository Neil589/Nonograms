package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.controller.Controller;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class InstView implements FXComponent {

    private final Controller controller;

    public InstView(Controller controller) {
        this.controller = controller;
    }

    @Override
    public Parent render() {
        StackPane layout = new StackPane();

        //provides puzzle instructions
        Label instlabel1 = new Label("Left Click to shade a cell (Green)");

        layout.getChildren().add(instlabel1);
        return layout;
    }
}
