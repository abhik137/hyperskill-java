package tictactoe;

public enum BoardState {
    GAME_IN_PROGRESS("Game not finished"),
    DRAW("Draw"),
    X_WINS("X wins"),
    O_WINS("O wins");

    private final String stringStatus;

    BoardState(String status) {
        this.stringStatus = status;
    }

    public String getStringStatus() {
        return this.stringStatus;
    }
}