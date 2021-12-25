package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.PuzzleLibrary;
import com.comp301.a09nonograms.controller.Controller;
import com.comp301.a09nonograms.model.Clues;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;

import java.util.Arrays;
import java.util.List;

public class GridView implements FXComponent {
    private final Controller controller;
    private final boolean flag = false;

    public GridView(Controller controller) {
        this.controller = controller;
    }

    @Override
    public Parent render() {
        GridPane layout = new GridPane();
        layout.setHgap(10);
        layout.setVgap(10);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(30, 30, 30, 30));
        layout.setStyle("-fx-border-color: black");
        List<Clues> clues = PuzzleLibrary.create(); //creating the puzzle library


        //creating our vertical clues based on our dimensions
        for (int i = 1; i < controller.getClues().getWidth() + 1; i++) {
            Label tile;
            tile =
                    new Label(
                            (Arrays.toString(
                                    zerofinder(clues.get(controller.getPuzzleIndex()).getColClues(i - 1)))
                                    .replace("[", ""))
                                    .replace("]", ""));
            tile.setStyle("-fx-border-color: black");
            tile.getStyleClass().add("tile");
            tile.getStyleClass().add("tile-" + clues);
            tile.setPadding(new Insets(2, 5, 2, 5));
            layout.add(tile, i, 0);
        }

        //creating our horizontal clues based on our dimensions
        for (int i = 1; i < controller.getClues().getHeight() + 1; i++) {
            Label tile;
            tile =
                    new Label(
                            Arrays.toString(zerofinder(clues.get(controller.getPuzzleIndex()).getRowClues(i - 1)))
                                    .replace("[", "")
                                    .replace("]", ""));
            tile.setStyle("-fx-border-color: black");
            tile.getStyleClass().add("tile");
            tile.getStyleClass().add("tile-" + clues);
            tile.setPadding(new Insets(2, 5, 2, 5));
            layout.add(tile, 0, i);
        }

        //creating our cells as buttons so they are clickable
        for (int i = 1; i < controller.getClues().getHeight() + 1; i++)
            for (int j = 1; j < controller.getClues().getWidth() + 1; j++)
                layout.add(makeButton(j, i), j, i);
        System.out.println(
                "hi: "
                        + Arrays.toString(
                        (clues
                                .get(controller.getPuzzleIndex())
                                .getRowClues(controller.getPuzzleIndex() + 1))));
        return layout;
    }

    private Button makeButton(int num, int num2) {
        Button tile;
        tile = new Button();
        tile.setStyle("-fx-background-color: #808080; ");
        //right click to shade a cell
        tile.setOnMouseClicked(
                event -> {
                    if (event.getButton() == MouseButton.PRIMARY) {
                        tile.setStyle("-fx-background-color: #00FF00; ");
                        controller.toggleShaded(
                                GridPane.getRowIndex(makeButton(num, num2)),
                                GridPane.getColumnIndex(makeButton(num, num2)));
                        //left click to eliminate a cell
                    } else if (event.getButton() == MouseButton.SECONDARY) {
                        tile.setStyle("-fx-background-color: #ff0000; ");
                        controller.toggleEliminated(
                                GridPane.getRowIndex(makeButton(num, num2)),
                                GridPane.getColumnIndex(makeButton(num, num2)));
                    }

                    // double click to clear a cell
                    if (event.getButton().equals(MouseButton.PRIMARY)) {
                        if (event.getClickCount() == 2) {
                            tile.setStyle("-fx-background-color: #808080; ");
                        }
                    }
                    if (event.getButton().equals(MouseButton.SECONDARY)) {
                        if (event.getClickCount() == 2) {
                            tile.setStyle("-fx-background-color: #808080; ");
                        }
                    }
                });
        tile.setPadding(new Insets(0, 0, 10, 30));
        tile.getStyleClass().add("tile");
        return tile;
    }

    private String[] zerofinder(int[] arr) {
        //helper method to format the clues
        String str = arr.toString();
        String[] cars = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                cars[i] = String.valueOf(arr[i]);
            }
            if (arr[i] == 0) {
                cars[i] = " ";
            }
        }
        return cars;
    }
}
