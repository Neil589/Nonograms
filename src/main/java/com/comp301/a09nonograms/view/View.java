package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.controller.Controller;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

public class View implements FXComponent {
    private final Controller controller;

    public View(Controller controller) {
        this.controller = controller;
    }

    @Override
    public Parent render() {
        VBox layout = new VBox();

        // Counter View
        CountView countview = new CountView(controller);
        layout.getChildren().add(countview.render());

        //creates a space between UI components vertically
        SpaceView spaceView = new SpaceView(controller);
        layout.getChildren().add(spaceView.render());

        // instructview- displays instructions to UI
        InstView instview = new InstView(controller);
        layout.getChildren().add(instview.render());

        InstView2 instview2 = new InstView2(controller);
        layout.getChildren().add(instview2.render());

        InstView3 instview3 = new InstView3(controller);
        layout.getChildren().add(instview3.render());

        InstView4 instview4 = new InstView4(controller);
        layout.getChildren().add(instview4.render());

        SpaceView spaceView2 = new SpaceView(controller);
        layout.getChildren().add(spaceView2.render());

        SolveView solveView = new SolveView(controller);
        layout.getChildren().add(solveView.render());

        // Clues + Grid View
        GridView gridview = new GridView(controller);
        layout.getChildren().add(gridview.render());

        // Buttons View
        ButtonView buttoneview = new ButtonView(controller);
        layout.getChildren().add(buttoneview.render());

        return layout;
    }
}
