package tictactoe.player;

import tictactoe.Board;

import java.util.Scanner;

public interface Player {
    void move();

    static Player getPlayerInstance(String input, Board board, char playerAlias, Scanner sc) {
        Player pl = null;
        switch (input) {
            case "user":
                pl = new HumanPlayer(board, sc);
                break;
            case "easy":
                pl = new EasyAiPlayer(board);
                break;
            case "medium":
                pl = new MediumAiPlayer(board, playerAlias);
                break;
            case "hard":
                pl = new MinimaxAiPlayer(board, playerAlias);
            default:
                break;
        }
        return pl;
    }
}
