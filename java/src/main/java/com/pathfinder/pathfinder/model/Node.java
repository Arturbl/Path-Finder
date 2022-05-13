package com.pathfinder.pathfinder.model;

import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Node extends Rectangle {

    private final Matrix matrix;
    private boolean visited;
    private int line;
    private int col;


    public Node(int line, int col, Matrix matrix) {
        this.visited = false;
        this.line = line;
        this.col = col;
        this.matrix = matrix;
    }

    public int getLine() {
        return line;
    }

    public int getCol() {
        return col;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isEqual(Node node) {
        return line == node.getLine() && col == node.getCol();
    }

    @Override
    public String toString() {
        return "Node{" + "line=" + line + ", col=" + col + '}';
    }

    public ArrayList<Node> getNeighbours() {
        final ArrayList<Node> neighbours = new ArrayList<>();
        // divide the elements around the main node into a smaller matrix
        int lineIndexStart = line == 0 ? line : line - 1; // row counter start
        while(lineIndexStart <= (line == Matrix.LINES - 1 ? line : line + 1)) {
            int colIndexStart = col == 0 ? col : col - 1; // col counter start
            while(colIndexStart <= (col == Matrix.COLS - 1 ? col : col + 1)) {
                Node currentNode = matrix.getNode(lineIndexStart, colIndexStart);
                if( !currentNode.isEqual(this) ) { // prevent adding the current node
                    neighbours.add(currentNode);
                }
                ++colIndexStart;
            }
            ++lineIndexStart;
        }
        return neighbours;
    }

    public double calcDistance() {
        Node endNode = matrix.getEndNode();
        return Math.sqrt(
                Math.pow(getCol() - endNode.getCol(), 2) +
                Math.pow(getLine() - endNode.getLine(), 2)
        );
    }

}
