import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int columns = sc.nextInt();

        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int p = sc.nextInt();
        int q = sc.nextInt();

        //swap col p with col q
        for (int i = 0; i < rows; i++) {
            int tmp = matrix[i][p];
            matrix[i][p] = matrix[i][q];
            matrix[i][q] = tmp;
        }

        for (int[] vector: matrix) {
            for (int v: vector) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }
}