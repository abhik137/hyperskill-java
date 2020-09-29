import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inp = sc.next();
        // String[] nums = inp.split("");
        // System.out.println(Arrays.toString(nums));
        char[] chars = inp.toCharArray();

        for (int i = 0, j = inp.length() - 1; i <= j; i++, j--) {
            if (chars[i] != chars[j]) {
                System.out.println("no");
                return;
            }
        }

        System.out.println("yes");
    }
}