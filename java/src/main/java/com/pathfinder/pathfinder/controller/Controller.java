package com.pathfinder.pathfinder.controller;

import com.pathfinder.pathfinder.model.Matrix;
import com.pathfinder.pathfinder.model.Node;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private final Matrix matrix;

    public Controller(Matrix matrix) {
        this.matrix = matrix;
        run();
    }

    public void run() {
        List<Node> path = getNextNode(matrix.getMainNode(), new ArrayList<>());
        path.forEach((Node node) -> {
            node.setFill(Color.ORANGE);
        });
    }

    private List<Node> getNextNode(Node currentNode, List<Node> path) {
        List<Node> neighbours = currentNode.getNeighbours();
        Node nextNode = neighbours.get(0);
        for(Node node : neighbours) {
            if(node.isEqual(matrix.getEndNode())) {
                return path;
            }
            double distance = node.calcDistance();
            if( distance < nextNode.calcDistance() ) {
                nextNode = node;
            }
        }
        path.add(nextNode);
        return getNextNode(nextNode, path);
    }

}


