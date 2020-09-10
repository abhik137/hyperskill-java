package tictactoe;

import tictactoe.player.Player;

import java.util.List;
import java.util.Scanner;

public class Game {
    private Board board;
    private final Scanner sc = new Scanner(System.in);

    public void startGame() {
        while (true) {
            System.out.print("Input command: ");
            String input = sc.nextLine();

            // handle input
            String[] inpArr = input.split(" ");
            boolean isValidInput = isValidInput(inpArr);

            String command = inpArr[0];

            switch (command) {
                case "start":
                    this.board = new Board();
                    board.printBoard();
                    break;
                case "exit":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Bad parameters!");
                    continue;
            }

            if (!isValidInput)
                continue;

            Player p1 = Player.getPlayerInstance(inpArr[1], board, sc);
            Player p2 = Player.getPlayerInstance(inpArr[2], board, sc);

            while (board.getGameStatus() == BoardState.GAME_IN_PROGRESS) {
                // player1 nad player2 move alternately till game finishes
                p1.move();
                if (board.getGameStatus() != BoardState.GAME_IN_PROGRESS) {
                    break;
                }
                p2.move();
            }

            System.out.println(board.getGameStatus().getStringStatus());
        }
    }

    private boolean isValidInput(String[] inpArr) {
        List<String> validInputs = List.of("user", "easy");
        if (inpArr.length != 3) {
            System.out.println("Bad parameters!");
            return false;
        }
        for (int i = 1; i < 3; i++) {   // i = 1,2
            if (!validInputs.contains(inpArr[i])) {
                System.out.println("Bad parameters!");
                return false;
            }
        }
        return true;
    }
}
