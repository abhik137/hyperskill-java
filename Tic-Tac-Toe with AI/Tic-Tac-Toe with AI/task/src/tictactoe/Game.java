package tictactoe;

import java.util.Scanner;

public class Game {
    private Board board;
    private final Scanner sc = new Scanner(System.in);

    public void startGame() {
        System.out.print("Enter cells: ");
        String input = sc.nextLine();

        this.board = new Board(input);
        board.printBoard();

        boolean isValidCoordinate = false;
        while (!isValidCoordinate) {
            System.out.print("Enter the coordinates: ");
            String coordinates = sc.nextLine();

            if (isValidCoordinate = isValidCoordinate(coordinates)) {   // validate co-ordinates
                String[] parts = coordinates.split(" ");
                /*
                 * y is column, x is row, since the co-ordinate map is like this:
                 * (1, 3) (2, 3) (3, 3)
                 * (1, 2) (2, 2) (3, 2)
                 * (1, 1) (2, 1) (3, 1)
                 * the first co-ordinate represents the column
                 */
                int y = Integer.parseInt(parts[0]);
                int x = Integer.parseInt(parts[1]);   // +1 as we are assuming 1-indexing for input to nextMove()
                board.nextMove(x, y);
                board.printBoard();
                BoardState currentGameStatus = board.getGameStatus();
                System.out.println(currentGameStatus.getStringStatus());
            }
        }
    }

    private boolean isValidCoordinate(String coordinates) {
        String[] parts = coordinates.split(" ");
        try {
            int y = Integer.parseInt(parts[0]);
            int x = Integer.parseInt(parts[1]);

            if (x < 1 || x > 3 || y < 1 || y > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                return false;
            }
            if (!board.isCellEmpty(x, y)) {
                System.out.println("This cell is occupied! Choose another one!");
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("You should enter numbers!");
            return false;
        }
        return true;
    }
}
