package objects;

import enums.Box;
import utils.Coord;
import utils.Ranges;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Map {

    private final static int IMAGE_SIZE = 30; // размер картинки одинаковый по x и по y

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

    public BufferedImage draw() {
        BufferedImage img = new BufferedImage(Ranges.COLS * IMAGE_SIZE,
                Ranges.ROWS * IMAGE_SIZE, BufferedImage.TYPE_INT_RGB);
        Graphics g = img.getGraphics();

        for (Coord coord : Ranges.getCoords()) {
            g.drawImage((Image) matrix[coord.x][coord.y].image,
                    coord.x * IMAGE_SIZE, coord.y * IMAGE_SIZE,
                    IMAGE_SIZE, IMAGE_SIZE, null);
        }

        return img;
    }

}