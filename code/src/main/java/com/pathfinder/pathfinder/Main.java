package com.pathfinder.pathfinder;

import com.pathfinder.pathfinder.controller.Controller;
import com.pathfinder.pathfinder.model.Matrix;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Main extends Application {

    private static final int WIDTH = 360;
    private static final int HEIGHT = 450;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Matrix matrix = new Matrix(WIDTH, HEIGHT);

        Scene scene = new Scene(matrix.getVBox(), WIDTH + 10, HEIGHT ); // add 10 to add extra space to last col
        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                matrix.choosePositions(); // init random positions
                new Controller(matrix);// run algorithm
            }
        });

        stage.setTitle("PathFinder");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

}

