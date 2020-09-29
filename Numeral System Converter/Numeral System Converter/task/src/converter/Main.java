package converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int radix = sc.nextInt();
        String output = "";

        switch (radix) {
            case 2:
                System.out.println("0b" + Long.toBinaryString(num));
                break;
            case 8:
                System.out.println("0" + Long.toOctalString(num));
                break;
            case 16:
                System.out.println("0x" + Long.toHexString(num));
                break;
            default:
                break;
        }
    }
}
