import objects.Map;
import enums.GameState;

public interface ModelListener {
    void updateMap(Map map);
    void updateScore(int score);
    void updateGameState(GameState state);
}
