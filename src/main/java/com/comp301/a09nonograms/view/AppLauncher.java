package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.PuzzleLibrary;
import com.comp301.a09nonograms.controller.Controller;
import com.comp301.a09nonograms.controller.ControllerImpl;
import com.comp301.a09nonograms.model.Clues;
import com.comp301.a09nonograms.model.Model;
import com.comp301.a09nonograms.model.ModelImpl;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.List;

public class AppLauncher extends Application {
    @Override
    public void start(Stage stage) {
        // TODO: Launch your GUI here
        List<Clues> clues = PuzzleLibrary.create();
        Model model = new ModelImpl(clues);

        // Controller
        Controller controller = new ControllerImpl(model);

        // View
        View view = new View(controller);

        // MakeScene
        Scene scene = new Scene(view.render());
        stage.setScene(scene);

        model.addObserver(
                (Model m) -> {
                    scene.setRoot(view.render());
                    stage.sizeToScene();
                });

        // Show The Stage
        stage.setTitle("Nonograms");
        stage.show();
    }
}
