import enums.GameState;
import objects.Head;
import objects.Map;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Model {

    private ModelListener listener;

    private Timer timer;
    private GameState state;
    private int score;

    private Map map;
    private Head head;

    public Model() {
        System.out.println("Model->constructor");

        timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isPlaying()) {
                    moveHead();

                    map.update();

                    listener.updateMap(map.draw());
                    listener.updateGameState(state);
                    listener.updateScore(score);
                }
            }
        });

        map = new Map();
    }

    public void addListener(ModelListener listener) {
        this.listener = listener;
    }

    public void setDirection(int dir) {
        head.turn(dir);
    }

    public void start() {
        System.out.println("Model->start");

        score = 0;
        state = GameState.PLAY;

        head = new Head();

        map.setHead(head);
        map.update();

        listener.updateScore(score);
        listener.updateGameState(state);
        listener.updateMap(map.draw());

        timer.start();
    }

    private boolean isPlaying() {
        return state == GameState.PLAY;
    }

    private void moveHead() {
        head.move();
    }

}
