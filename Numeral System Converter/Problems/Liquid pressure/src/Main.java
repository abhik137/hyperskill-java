import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double density = sc.nextDouble();
        double height = sc.nextDouble();
        double gravity = 9.8;

        double pressure = density * gravity * height;

        System.out.println(pressure);
    }
}