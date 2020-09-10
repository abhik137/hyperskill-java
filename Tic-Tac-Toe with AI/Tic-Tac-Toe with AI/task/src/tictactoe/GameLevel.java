package tictactoe;

import java.util.Optional;

public enum GameLevel {
    EASY("easy"),
    MEDIUM("medium"),
    HARD("hard");

    private String levelStr;

    GameLevel(String levelStr) {
        this.levelStr = levelStr;
    }

    public String getLevelStr() {
        return levelStr;
    }

    public Optional<GameLevel> fromString(String text) {
        for (GameLevel level: GameLevel.values()) {
            if (text.equals(level.getLevelStr())) {
                return Optional.of(level);
            }
        }
        return Optional.empty();
    }
}
