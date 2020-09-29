import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inp = sc.next();
        // String[] nums = inp.split("");
        // System.out.println(Arrays.toString(nums));
        char[] chars = inp.toCharArray();

        int sumFirst = 0;
        int sumLast = 0;

        for (int i = 0; i < 3; i++) {
            sumFirst += Character.getNumericValue(chars[i]);
            sumLast += Character.getNumericValue(chars[inp.length() - 1 - i]);
        }

        if (sumFirst == sumLast)
            System.out.println("Lucky");
        else
            System.out.println("Regular");

        // System.out.println(sumFirst);
        // System.out.println(sumLast);
    }
}