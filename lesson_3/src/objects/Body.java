package objects;

import utils.Coord;

import java.util.ArrayList;

// TODO: lesson 3
public class Body {

    private ArrayList<Coord> body;
    private Coord tail;

    public Body() {
        body = new ArrayList<>();
        body.add(new Coord(8, 7));
        body.add(new Coord(9, 7));
    }

    public ArrayList<Coord> getBody() {
        return body;
    }

    public void move(Coord coord) {
        tail = body.get(body.size() - 1);
        body.remove(tail);
        body.add(0, coord);
    }

    public void add() {
        System.out.println("Body->add");
        body.add(tail);
    }

}