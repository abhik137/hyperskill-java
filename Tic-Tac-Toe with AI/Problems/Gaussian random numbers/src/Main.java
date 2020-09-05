import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        int N = sc.nextInt();
        double M = sc.nextDouble();

        for (int seed = K; ; seed++) {
            Random rng = new Random(seed);
            boolean conditionSatisfied = true;

            for (int i = 0; i < N; i++) {
                double rnd = rng.nextGaussian();
                if (rnd > M) {
                    conditionSatisfied = false;
                    break;
                }
            }

            if (conditionSatisfied) {
                System.out.println(seed);
                break;
            }
        }
    }
}