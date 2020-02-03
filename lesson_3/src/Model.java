import objects.Map;
import enums.GameState;
import objects.Apple;
import objects.Body;
import objects.Head;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Model {

    private ModelListener listener;

    private Timer timer;
    private GameState state;
    private int score;

    private Map map;
    private Apple apple;
    private Head head;

    // TODO: lesson 3
    private Body body;

    public Model() {
        System.out.println("Model->constructor");

        timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isPlaying()) {
                    moveHead();

                    // TODO: lesson 3
                    moveBody();

                    // TODO: lesson 3
                    if (isBodyCaught()) {
                        catchBody();
                        timer.stop();
                    }

                    if (isAppleCaught()) {
                        catchApple();
                    }

                    // TODO: lesson 3
                    if (isGameWon()) {
                        win();
                        timer.stop();
                    }

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
        apple = new Apple();

        // TODO: lesson 3
        body = new Body();

        map.setHead(head);
        map.setApple(apple);

        // TODO: lesson 3
        map.setBody(body);

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

    // TODO: lesson 3
    private void moveBody() {
        body.move(head.getPrevCoord());
    }

    // TODO: lesson 3
    private boolean isBodyCaught() {
        for (int i = 0; i < body.getBody().size(); i++) {
            if (head.getCurCoord().equals(body.getBody().get(i))) {
                return true;
            }
        }
        return false;
    }

    // TODO: lesson 3
    private void catchBody() {
        System.out.println("Model->catchBody");
        state = GameState.LOSE;
    }

    // TODO: lesson 3
    private void win() {
        System.out.println("Model->win");
        state = GameState.WIN;
    }

    // TODO: lesson 3
    private boolean isGameWon() {
        return score >= 100;
    }

    private boolean isAppleCaught() {
        return head.getCurCoord().equals(apple.getCoord());
    }

    private void catchApple() {
        System.out.println("Model->catchApple");

        apple.make();
        body.add();
        score += 10;
    }

}
