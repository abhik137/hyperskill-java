package tictactoe.player;

import tictactoe.Board;

import java.util.Optional;

public class MinimaxAiPlayer implements Player {
    private Board board;
    private char maxPlayer;
    private char minPlayer;

    public MinimaxAiPlayer(Board board, char player) {
        this.board = board;
        this.maxPlayer = player;
        if (maxPlayer == 'X')
            minPlayer = 'O';
        else
            minPlayer = 'X';
    }

    @Override
    public void move() {
        System.out.println("Making move level \"hard\"");

        // scan the board and for every empty position evaluate the minimax score
        // and decide which move to make
        int[] coordinates = minimax();
        board.nextMove(coordinates[0] + 1, coordinates[1] + 1);
        board.printBoard();
    }

    /** return the co-ordinates for the move */
    private int[] minimax() {
        char[][] grid = board.getGrid();

        int bestScore = Integer.MIN_VALUE;
        int[] bestMove = null;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == ' ') {
                    grid[i][j] = maxPlayer;
                    int score = minValue(board);
                    if (score > bestScore) {
                        bestScore = score;
                        bestMove = new int[] {i, j};
                    }
                    grid[i][j] = ' ';
                }
            }
        }
        return bestMove;
    }

    private int maxValue(Board board) {
        char[][] grid = board.getGrid();
        Optional<String> result = terminalTest(grid);
        if (result.isPresent())
            return terminalScore(result.get());
        int score = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == ' ') {
                    grid[i][j] = maxPlayer;
                    score = Math.max(score, minValue(board));
                    grid[i][j] = ' ';
                }
            }
        }
        return score;
    }

    private int minValue(Board board) {
        char[][] grid = this.board.getGrid();
        Optional<String> result = terminalTest(grid);
        if (result.isPresent())
            return terminalScore(result.get());
        int score = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == ' ') {
                    grid[i][j] = minPlayer;
                    score = Math.min(score, maxValue(board));
                    grid[i][j] = ' ';
                }
            }
        }
        return score;
    }

    /** return status if game has reached a terminal state: win/loss/draw
     *  from the POV of maxPlayer
     */
    private Optional<String> terminalTest(char[][] grid) {
        Optional<String> result = Optional.empty();
        char winner = ' ';
        // check row
        for (int y = 0; y < 3; y++) {   // y == row
            if (grid[y][0] == grid[y][1] && grid[y][1] == grid[y][2] && grid[y][0] != ' ') {
                winner = grid[y][0];
            }
        }

        // check column
        for (int x = 0; x < 3; x++) {   // x == column
            if (grid[0][x] == grid[1][x] && grid[1][x] == grid[2][x] && grid[0][x] != ' ') {
                winner = grid[0][x];
            }
        }

        // check diagonal
        if (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && grid[0][0] != ' ') {
            winner = grid[0][0];
        }
        else if (grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0] && grid[0][2] != ' ') {
            winner = grid[0][2];
        }


        int emptySpots = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == ' ')
                    emptySpots++;
            }
        }

        // who won?
        if (winner == maxPlayer)
            result = Optional.of("win");
        else if (winner == minPlayer)
            result = Optional.of("loss");
        else if (winner == ' ' && emptySpots == 0)   // no empty spots and no winner => draw
            result = Optional.of("draw");

        return result;
    }

    /** score for terminal state (from the POV of player)
     * win = +1
     * draw = 0
     * loss = -1
     */
    private int terminalScore(String s) {
        switch (s) {
            case "win":
                return 10;
            case "draw":
                return 0;
            case "loss":
                return -10;
            default:
                return -2;
                // throw new Exception("Invalid terminal state: " + s);
        }
    }
}
