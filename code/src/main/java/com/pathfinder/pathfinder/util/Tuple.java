package com.pathfinder.pathfinder.util;

public class Tuple<X,Y> {

    private X x;
    private Y y;

    public Tuple(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    public X getX() {
        return x;
    }

    public Y getY() {
        return y;
    }

    public boolean equals(Tuple tuple) {
        return x != tuple.getX() || y != tuple.getY();
    }

}
