package objects;

import utils.Coord;
import utils.Ranges;

public class Apple {

    private Coord coord;

    public Apple() {
        make();
    }

    public void make() {
        System.out.println("Apple->make");
        coord = Ranges.getRandomCoord();
    }

    public Coord getCoord() {
        return coord;
    }

}
