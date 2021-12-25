package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.controller.Controller;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class InstView4 implements FXComponent {

    private final Controller controller;

    public InstView4(Controller controller) {
        this.controller = controller;
    }

    @Override
    public Parent render() {
        StackPane layout = new StackPane();
        //provides puzzle instructions
        Label instlabel3 = new Label("So ,4 means there are 4 connected, shaded cells");
        layout.getChildren().add(instlabel3);
        return layout;
    }
}
