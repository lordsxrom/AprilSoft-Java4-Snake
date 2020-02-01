package objects;

import utils.Coord;
import utils.Ranges;

public class Head {

    public final static int DIR_RIGHT = 1;
    public final static int DIR_DOWN = 2;
    public final static int DIR_LEFT = 3;
    public final static int DIR_UP = 4;

    private int direction;
    private Coord curCoord;
    private Coord prevCoord;

    public Head() {
        curCoord = new Coord(7, 7);
        prevCoord = curCoord;
        direction = DIR_LEFT;
    }

    public Coord getCurCoord() {
        return curCoord;
    }

    public Coord getPrevCoord() {
        return prevCoord;
    }

    public void turn(int dir) {
        if (Math.abs(direction - dir) != 2) {
            System.out.println("HEAD->turn->dir:" + dir);
            this.direction = dir;
        }
    }

    public void move() {
        Coord tmpCoord = new Coord(curCoord.x, curCoord.y);

        switch (direction) {
            case DIR_RIGHT: {
                tmpCoord.x += 1;
                if (Ranges.inRange(tmpCoord)) {
                    prevCoord = curCoord;
                    curCoord = tmpCoord;
                } else {
                    prevCoord = curCoord;
                    curCoord = new Coord(0, tmpCoord.y);
                }
                break;
            }
            case DIR_DOWN: {
                tmpCoord.y += 1;
                if (Ranges.inRange(tmpCoord)) {
                    prevCoord = curCoord;
                    curCoord = tmpCoord;
                } else {
                    prevCoord = curCoord;
                    curCoord = new Coord(tmpCoord.x, 0);
                }
                break;
            }
            case DIR_LEFT: {
                tmpCoord.x -= 1;
                if (Ranges.inRange(tmpCoord)) {
                    prevCoord = curCoord;
                    curCoord = tmpCoord;
                } else {
                    prevCoord = curCoord;
                    curCoord = new Coord(Ranges.getLastCoord().x, tmpCoord.y);
                }
                break;
            }
            case DIR_UP: {
                tmpCoord.y -= 1;
                if (Ranges.inRange(tmpCoord)) {
                    prevCoord = curCoord;
                    curCoord = tmpCoord;
                } else {
                    prevCoord = curCoord;
                    curCoord = new Coord(tmpCoord.x, Ranges.getLastCoord().y);
                }
                break;
            }
        }
        System.out.println("head->move>x:" + curCoord.x + ";y:" + curCoord.y);
    }

}
