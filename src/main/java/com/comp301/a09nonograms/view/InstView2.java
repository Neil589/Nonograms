package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.controller.Controller;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class InstView2 implements FXComponent {

    private final Controller controller;

    public InstView2(Controller controller) {
        this.controller = controller;
    }

    @Override
    public Parent render() {
        StackPane layout = new StackPane();

        //provides puzzle instructions
        Label instlabel2 = new Label("Right Click to eliminate a cell (Red)");
        layout.getChildren().add(instlabel2);
        return layout;
    }
}
