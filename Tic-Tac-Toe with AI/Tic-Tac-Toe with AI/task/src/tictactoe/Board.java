package tictactoe;

public class Board {
    char[][] matrix = new char[3][3];
    Player nextTurn = null;
    BoardState gameStatus = BoardState.GAME_IN_PROGRESS;
    int cellsFilled = 0;
    int noOfX = 0;
    int noOfO = 0;

    public Board(String input) {
        int idx = 0;
        for (int i = 2; i >= 0; i--) {
            for (int j = 0; j < 3; j++) {
                if (input.charAt(idx) == 'X'){
                    matrix[i][j] = input.charAt(idx);
                    cellsFilled++;
                    noOfX++;
                }
                else if (input.charAt(idx) == 'O'){
                    matrix[i][j] = input.charAt(idx);
                    cellsFilled++;
                    noOfO++;
                }
                else {  // (input.charAt(idx) == '_')
                    matrix[i][j] = ' ';
                }
                idx++;
            }
        }
    }

    public void nextMove(int x, int y) {
        matrix[x - 1][y - 1] = whoseTurnIsIt();
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

    private void updateGameStatus(int x, int y, Player current) {
        char currentChar = matrix[x - 1][y - 1];

        boolean isGameWon = (
            isRowComplete(x, currentChar) ||
            isColumnComplete(y, currentChar) ||
            isLeftDiagonalComplete(currentChar) ||
            isRightDiagonalComplete(currentChar)
        );
        if (isGameWon && current == Player.X)
            this.gameStatus = BoardState.X_WINS;
        else if (isGameWon && current == Player.O)
            this.gameStatus = BoardState.O_WINS;
        else if (cellsFilled == 9)
            this.gameStatus = BoardState.DRAW;
        else
            this.gameStatus = BoardState.GAME_IN_PROGRESS;
    }

    public void printBoard() {
        System.out.println("---------");
        for (int i = 2; i >= 0; i--) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.print("|\n");
        }
        System.out.println("---------");
    }

    private boolean isRightDiagonalComplete(char currentChar) {
        boolean isGameWon = true;
        for (int i = 0, j = 2; i < 3 & j > 0; i++, j--) {
            if (matrix[i][j] != currentChar) {
                isGameWon = false;
                break;
            }
        }
        return isGameWon;
    }

    private boolean isLeftDiagonalComplete(char currentChar) {
        boolean isGameWon = true;
        for (int i = 0, j = 0; i < 3 & j < 3; i++, j++) {
            if (matrix[i][j] != currentChar) {
                isGameWon = false;
                break;
            }
        }
        return isGameWon;
    }

    private boolean isColumnComplete(int y, char currentChar) {
        boolean isGameWon = true;
        int column = y - 1;
        for (int i = 0; i < 3; i++) {
            if (matrix[i][column] != currentChar) {
                isGameWon = false;
                break;
            }
        }
        return isGameWon;
    }

    private boolean isRowComplete(int x, char currentChar) {
        boolean isGameWon = true;
        int row = x - 1;
        for (int i = 0; i < 3; i++) {
            if (matrix[x - 1][i] != currentChar) {
                isGameWon = false;
                break;
            }
        }
        return isGameWon;
    }

    public boolean isCellEmpty(int x, int y) {
        return matrix[x - 1][y - 1] == ' ';
    }
}
