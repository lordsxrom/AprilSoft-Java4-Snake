package objects;

import enums.Box;
import utils.Coord;
import utils.Ranges;

public class Map {

    private Head head;
    private Apple apple;
    private Box[][] matrix;

    // TODO: lesson 3
    private Body body;

    public Map() {
        Ranges.setMatrixSize(15, 15);

        matrix = new Box[Ranges.COLS][Ranges.ROWS];
        for (Coord coord : Ranges.getCoords()) {
            matrix[coord.x][coord.y] = Box.ZERO;
        }
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public void setApple(Apple apple) {
        this.apple = apple;
    }

    // TODO: lesson 3
    public void setBody(Body body) {
        this.body = body;
    }

    public void update() {
        for (Coord coord : Ranges.getCoords()) {
            matrix[coord.x][coord.y] = Box.ZERO;
        }

        matrix[head.getCurCoord().x][head.getCurCoord().y] = Box.HEAD;
        matrix[apple.getCoord().x][apple.getCoord().y] = Box.APPLE;

        // TODO: lesson 3
        for (Coord coord : body.getBody()) {
            matrix[coord.x][coord.y] = Box.BODY;
        }
    }

    public Box getBox(Coord coord) {
        if (Ranges.inRange(coord)) {
            return matrix[coord.x][coord.y];
        }
        return null;
    }

}