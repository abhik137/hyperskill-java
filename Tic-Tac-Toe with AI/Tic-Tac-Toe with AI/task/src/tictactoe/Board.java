package tictactoe;

import java.util.stream.IntStream;

public class Board {
    private final char[][] grid = new char[3][3]; // x/i => row, y/j => column
    private int noOfX = 0;
    private int noOfO = 0;
    private int cellsFilled = 0;
    private PlayerHandle nextTurn = null;
    private BoardState gameStatus = BoardState.GAME_IN_PROGRESS;

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
                } else if (input.charAt(idx) == 'O') {
                    grid[i][j] = input.charAt(idx);
                    cellsFilled++;
                    noOfO++;
                } else {  // (input.charAt(idx) == '_')
                    grid[i][j] = ' ';
                }
                idx++;
            }
        }
    }

    public void nextMove(int x, int y) {
        grid[x - 1][y - 1] = whoseTurnIsIt();
        cellsFilled++;
        updateGameStatus(x, y, nextTurn);
        nextTurn = nextPlayer();
    }

    private PlayerHandle nextPlayer() {
        if (this.nextTurn == PlayerHandle.X)
            return PlayerHandle.O;
        else
            return PlayerHandle.X;
    }

    private char whoseTurnIsIt() {
        if (nextTurn == null) {
            if (noOfX == noOfO)
                nextTurn = PlayerHandle.X;
            else    // noOfX > noOfO
                nextTurn = PlayerHandle.O;
        }
        return this.nextTurn.toString().charAt(0);
    }

    private void updateGameStatus(int x, int y, PlayerHandle currentPlayer) {
        boolean isGameWon = isGameWon(x, y, currentPlayer.toString().charAt(0));

        if (isGameWon && currentPlayer == PlayerHandle.X)
            this.gameStatus = BoardState.X_WINS;
        else if (isGameWon && currentPlayer == PlayerHandle.O)
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

    public boolean isGameWon(int x, int y, char player) {
        return checkRow(x - 1) || checkColumn(y - 1) || checkDiagonal(player);
    }

    public boolean isEmptyCell(int x, int y) {
        return grid[x - 1][y - 1] == ' ';
    }

    public void setCellEmpty(int x, int y) {
        grid[x - 1][y - 1] = ' ';
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

    public char[][] getGrid() {
        return this.grid;
    }
}
