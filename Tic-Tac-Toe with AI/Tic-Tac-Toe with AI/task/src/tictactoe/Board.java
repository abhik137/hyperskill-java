package tictactoe;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Board {
    private char[][] grid = new char[3][3]; // x/i => row, y/j => column
    private int noOfX = 0;
    private int noOfO = 0;
    private int cellsFilled = 0;
    private Player nextTurn = null;
    private BoardState gameStatus = BoardState.GAME_IN_PROGRESS;
    private Random rng = ThreadLocalRandom.current();

    private final int MAX_CELLS = 9;
    private final int GRID_SIZE = grid.length;

    public Board() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                grid[i][j] = ' ';
            }
        }
    }

    public Board(String input) {
        int idx = 0;
        for (int i = 2; i >= 0; i--) {
            for (int j = 0; j < 3; j++) {
                if (input.charAt(idx) == 'X'){
                    grid[i][j] = input.charAt(idx);
                    cellsFilled++;
                    noOfX++;
                }
                else if (input.charAt(idx) == 'O'){
                    grid[i][j] = input.charAt(idx);
                    cellsFilled++;
                    noOfO++;
                }
                else {  // (input.charAt(idx) == '_')
                    grid[i][j] = ' ';
                }
                idx++;
            }
        }
    }

    public void nextMoveAI() {
        // generate a random no. b/w [0,9) corresponding to a cell that is not occupied
        while (true) {
            int rnd = rng.nextInt(MAX_CELLS);
            // map rnd to (x,y)
            int x = rnd / 3;
            int y = rnd % 3;

            // need to add 1 as other methods expect 1-indexed coordinates in input
            if (isEmptyCell(x + 1 , y + 1)) {
                nextMove(x + 1 , y + 1);
                break;
            }
        }
    }

    public void nextMove(int x, int y) {
        grid[x - 1][y - 1] = whoseTurnIsIt();
        cellsFilled++;
        updateGameStatus(x,y,nextTurn);
        nextTurn = nextPlayer();
    }

    private Player nextPlayer() {
        if (this.nextTurn == Player.X)
            return Player.O;
        else
            return Player.X;
    }

    private char whoseTurnIsIt() {
        if (nextTurn == null) {
            if (noOfX == noOfO)
                nextTurn = Player.X;
            else    // noOfX > noOfO
                nextTurn = Player.O;
        }
        return this.nextTurn.toString().charAt(0);
    }

    private void updateGameStatus(int x, int y, Player currentPlayer) {
        boolean isGameWon = checkRow(x - 1) || checkColumn(y - 1) || checkDiagonal(currentPlayer.toString().charAt(0));

        if (isGameWon && currentPlayer == Player.X)
            this.gameStatus = BoardState.X_WINS;
        else if (isGameWon && currentPlayer == Player.O)
            this.gameStatus = BoardState.O_WINS;
        else if (cellsFilled == MAX_CELLS)
            this.gameStatus = BoardState.DRAW;
        else
            this.gameStatus = BoardState.GAME_IN_PROGRESS;
    }


    private boolean checkRow(int x) {
        return IntStream.of(1, 2).allMatch(i -> grid[x][0] == grid[x][i]);  // i.e. grid[x][0] == grid[x][1] == grid[x][2]
    }

    private boolean checkColumn(int y) {
        return IntStream.of(1, 2).allMatch(i -> grid[0][y] == grid[i][y]);  // i.e. grid[0][y] == grid[1][y] == grid[2][y]
    }

    private boolean checkDiagonal(char c) {
        return (grid[0][0] == c && IntStream.of(1,2).allMatch(i -> grid[0][0] == grid[i][i])) ||    // grid[0,0] == grid[1,1] == grid[2,2]
               (grid[0][2] == c && IntStream.of(1,2).allMatch(i -> grid[0][2] == grid[i][2 - i]));  // grid[0,2] == grid[1,1] == grid[2,0]
    }

    public boolean isEmptyCell(int x, int y) {
        return grid[x - 1][y - 1] == ' ';
    }

    public void printBoard() {
        StringBuilder sb = new StringBuilder();
        sb.append("---------\n");
        for (int i = 2; i >= 0; i--) {
            sb.append("| ");
            for (int j = 0; j < 3; j++) {
                sb.append(grid[i][j]);
                sb.append(" ");
            }
            sb.append("|\n");
        }
        sb.append("---------");

        System.out.println(sb.toString());
    }

    public BoardState getGameStatus() {
        return this.gameStatus;
    }

    @Deprecated
    private boolean isRightDiagonalComplete(char currentChar) {
        boolean isGameWon = true;
        for (int i = 0, j = 2; i < 3 & j > 0; i++, j--) {
            if (grid[i][j] != currentChar) {
                isGameWon = false;
                break;
            }
        }
        return isGameWon;
    }

    @Deprecated
    private boolean isLeftDiagonalComplete(char currentChar) {
        boolean isGameWon = true;
        for (int i = 0, j = 0; i < 3 & j < 3; i++, j++) {
            if (grid[i][j] != currentChar) {
                isGameWon = false;
                break;
            }
        }
        return isGameWon;
    }

    @Deprecated
    private boolean isColumnComplete(int y, char currentChar) {
        boolean isGameWon = true;
        int column = y - 1;
        for (int i = 0; i < 3; i++) {
            if (grid[i][column] != currentChar) {
                isGameWon = false;
                break;
            }
        }
        return isGameWon;
    }

    @Deprecated
    private boolean isRowComplete(int x, char currentChar) {
        boolean isGameWon = true;
        int row = x - 1;
        for (int i = 0; i < 3; i++) {
            if (grid[x - 1][i] != currentChar) {
                isGameWon = false;
                break;
            }
        }
        return isGameWon;
    }
}
