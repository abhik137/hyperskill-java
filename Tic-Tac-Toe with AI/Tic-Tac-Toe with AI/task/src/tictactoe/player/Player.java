package tictactoe.player;

import tictactoe.Board;

import java.util.Scanner;

public interface Player {
    void move();

    static Player getPlayerInstance(String input, Board board, Scanner sc) {
        Player pl = null;
        switch (input) {
            case "user":
                pl = new HumanPlayer(board, sc);
                break;
            case "easy":
                pl = new EasyAiPlayer(board);
                break;
            default:
                break;
        }
        return pl;
    }
}
