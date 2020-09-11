package tictactoe.player;

import tictactoe.Board;

import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MediumAiPlayer implements Player {

    private Board board;
    private Random rng = ThreadLocalRandom.current();
    private int MAX_CELLS = 9;
    private char player;
    private char opponent;

    public MediumAiPlayer(Board board, char player) {
        this.board = board;
        this.player = player;
        if (player == 'X')
            opponent = 'O';
        else
            opponent = 'X';
    }

    @Override
    public void move() {
        System.out.println("Making move level \"medium\"");

        Optional<String> playerCanWin = nextMoveWin(player);
        Optional<String> opponentCanWin = nextMoveWin(opponent);

        // go for win if possible
        if (playerCanWin.isPresent()) {
            String[] coordinate = playerCanWin.get().split(",");
            board.nextMove(
                    Integer.parseInt(coordinate[0]),
                    Integer.parseInt(coordinate[1])
            );
            board.printBoard();
            return;
        }

        // block if opponent is winning
        if (opponentCanWin.isPresent()) {
            String[] coordinate = opponentCanWin.get().split(",");
            board.nextMove(
                    Integer.parseInt(coordinate[0]),
                    Integer.parseInt(coordinate[1])
            );
            board.printBoard();
            return;
        }

        // otherwise, random move
        randomMove();
        board.printBoard();
    }

    private Optional<String> nextMoveWin(char playerChar) {
        char[][] grid = board.getGrid();
        int x = -1;
        int y = -1;

        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (board.isEmptyCell(i, j)) {
                    grid[i - 1][j - 1] = playerChar;    // tmp set and check
                    if(board.isGameWon(i, j, playerChar)) {
                        x = i;
                        y = j;
                        board.setCellEmpty(x, y);       // reset tmp change
                        break;
                    }
                    board.setCellEmpty(i, j);           // reset tmp change
                }
            }
            if (x != -1)
                break;
        }

        if (x != -1) {                  // just checking x is enough
            return Optional.of(x + "," + y);
        }

        return Optional.empty();
    }

    private void randomMove() {
        while (true) {
            // generate a random no. b/w [0,9) corresponding to a cell that is not occupied
            int rnd = rng.nextInt(MAX_CELLS);

            // map rnd to (x,y)
            int x = rnd / 3;
            int y = rnd % 3;

            // need to add 1 as other methods expect 1-indexed coordinates in input
            if (board.isEmptyCell(x + 1 , y + 1)) {
                board.nextMove(x + 1 , y + 1);
                break;
            }
        }
    }
}
