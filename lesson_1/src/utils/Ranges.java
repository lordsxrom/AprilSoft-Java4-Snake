package utils;

import java.util.ArrayList;
import java.util.Random;

public class Ranges {

    private static Coord lastCoord;
    private static ArrayList<Coord> coords;
    private static Random random = new Random();

    public static int COLS;
    public static int ROWS;

    public static void setMatrixSize(int cols, int rows) {
        COLS = cols;
        ROWS = rows;

        coords = new ArrayList<>();
        for (int y = 0; y < rows; y++)
            for (int x = 0; x < cols; x++)
                coords.add(new Coord(x, y));
        lastCoord = coords.get(coords.size() - 1);
    }

    public static boolean inRange(Coord coord) {
        return coord.x >= 0 && coord.x <= lastCoord.x && coord.y >= 0 && coord.y <= lastCoord.y;
    }

    public static ArrayList<Coord> getCoords() {
        return coords;
    }

}
