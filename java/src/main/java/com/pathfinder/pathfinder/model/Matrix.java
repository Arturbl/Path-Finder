package com.pathfinder.pathfinder.model;

import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.util.concurrent.ThreadLocalRandom;

public class Matrix extends Parent {

    static final int LINES = 10;
    static final int COLS = 10;

    private final VBox matrix = new VBox();

    private Node mainNode;
    private Node endNode;

    public Matrix(int width, int height) {
        for (int i = 0; i < LINES; i++) {
            HBox col = new HBox();
            for (int j = 0; j < COLS; j++) {
                Node node = new Node(i,j, this);
                node.setStyle("-fx-fill: white; -fx-stroke: black; -fx-stroke-width: 0.5;");
                node.setWidth(width / 10);
                node.setHeight(height / 10);
                col.getChildren().add(node);
            }
            matrix.getChildren().add(col);
        }
    }

    public VBox getVBox() {
        return matrix;
    }

    public Node getMainNode() {
        return mainNode;
    }

    public Node getEndNode() {
        return endNode;
    }

    public Node getNode(int line, int col) {
        HBox hBox;
        Rectangle rect;
        try {
            hBox = (HBox) getVBox().getChildren().get(line);
            rect = (Rectangle) hBox.getChildren().get(col);
        } catch (Exception e) {
            return null;
        }
        return (Node) rect;
    }

    private void repaint() {
        for (int i = 0; i < 10; i++) {
            HBox hBox = (HBox) getVBox().getChildren().get(i);
            for (int j = 0; j < 10; j++) {
                Node node = (Node) hBox.getChildren().get(j);
                node.setVisited(false);
                node.setFill(Color.WHITE);
            }
        }
    }

    public void choosePositions() {
        repaint();
        for (int i = 2; i < 4; i++) {
            int line = ThreadLocalRandom.current().nextInt(0, 10);
            int col = ThreadLocalRandom.current().nextInt(0, 10);
            if(i % 2 == 0) { // select main node
                this.mainNode = getNode(line, col);
                paintSquare(line, col, Color.GREY);
            } else { // select end Node
                this.endNode = getNode(line, col);
                paintSquare(line, col, Color.GREEN);
            }
        }
    }


    public void paintSquare(int line, int col, Paint paint) {
        Rectangle rect = getNode(line, col);
        rect.setFill(paint);
    }



}
