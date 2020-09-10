package tictactoe.player;

import tictactoe.Board;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class EasyAiPlayer implements Player {

    private Board board;
    private Random rng = ThreadLocalRandom.current();
    private int MAX_CELLS = 9;

    public EasyAiPlayer(Board board) {
        this.board = board;
    }

    @Override
    public void move() {
        System.out.println("Making move level \"easy\"");

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

        board.printBoard();
    }
}
