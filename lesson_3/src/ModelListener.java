import enums.GameState;

import java.awt.image.BufferedImage;

public interface ModelListener {
    void updateMap(BufferedImage map);
    void updateScore(int score);
    void updateGameState(GameState state);
}
