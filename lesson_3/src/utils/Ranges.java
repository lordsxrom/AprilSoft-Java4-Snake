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

    public static Coord getRandomCoord() {
        return new Coord(random.nextInt(lastCoord.x), random.nextInt(lastCoord.y));
    }

    public static ArrayList<Coord> getCoordsAround(Coord coord) {
        ArrayList<Coord> list = new ArrayList<>();
        for (int x = coord.x - 1; x <= coord.x + 1; x++) {
            for (int y = coord.y - 1; y <= coord.y + 1; y++) {
                Coord around;
                if (inRange(around = new Coord(x, y))) {
                    if (!around.equals(coord)) {
                        list.add(around);
                    }
                }
            }
        }
        return list;
    }

    public static Coord getLastCoord() {
        return lastCoord;
    }

    public static ArrayList<Coord> getCoords() {
        return coords;
    }

}
