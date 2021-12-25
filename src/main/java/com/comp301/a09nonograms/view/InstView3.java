package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.controller.Controller;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class InstView3 implements FXComponent {

    private final Controller controller;

    public InstView3(Controller controller) {
        this.controller = controller;
    }

    @Override
    public Parent render() {
        StackPane layout = new StackPane();

        //provides puzzle instructions
        Label instlabel3 = new Label("A space for a clue indicates that there is no clue.");
        layout.getChildren().add(instlabel3);
        return layout;
    }
}
