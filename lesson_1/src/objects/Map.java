package objects;

import enums.Box;
import utils.Coord;
import utils.Ranges;

public class Map {

    private Head head;
    private Box[][] matrix;

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

    public void update() {
        for (Coord coord : Ranges.getCoords()) {
            matrix[coord.x][coord.y] = Box.ZERO;
        }

        matrix[head.getCurCoord().x][head.getCurCoord().y] = Box.HEAD;
    }

    public Box getBox(Coord coord) {
        if (Ranges.inRange(coord)) {
            return matrix[coord.x][coord.y];
        }
        return null;
    }

}