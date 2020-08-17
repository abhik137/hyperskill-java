import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        String[][] matrix = new String[N][N];
        int mid = N / 2;    // +1 not needed due to 0-indexing

        for (String[] vector: matrix) {
            Arrays.fill(vector, ".");
        }


        for (int i = 0; i < N; i++) {
            matrix[i][i] = "*";             // main diagonal
            matrix[i][(N - 1) - i] = "*";   // secondary diagonal
            matrix[i][mid] = "*";           // middle column fill
            matrix[mid][i] = "*";           // middle row fill
        }

        for (String[] vector: matrix) {
            System.out.println(String.join(" ", vector));
        }
    }
}