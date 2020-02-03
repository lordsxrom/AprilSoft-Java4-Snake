package objects;

import enums.Box;
import utils.Coord;
import utils.Ranges;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Map {

    private final static int IMAGE_SIZE = 30; // размер картинки одинаковый по x и по y

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