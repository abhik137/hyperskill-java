package converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int srcRadix = sc.nextInt();
        String num = sc.next();
        int targetRadix = sc.nextInt();
        int decimalNum = 0;
        String output = "";

        if (srcRadix == 1) {
            decimalNum = num.length();
        } else {
            decimalNum = Integer.parseInt(num, srcRadix);
        }

        if (targetRadix == 1) {
            // for (int i = 0; i < decimalNum; i++) {
            //     output += "1";
            // }
            output = "1".repeat(decimalNum);
        } else {
            output = Integer.toString(decimalNum, targetRadix);
        }
        System.out.println(output);
    }
}
