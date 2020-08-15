import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        String type = sc.next();

        switch (type) {
            case "triangle":
                areaTriangle(sc);
                break;
            case "rectangle":
                areaRectangle(sc);
                break;
            case "circle":
                areaCircle(sc);
                break;
            default:
                System.out.println("Invalid Input!");
                break;
        }
    }

    private static void areaTriangle(Scanner sc) {
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        //calculate area of triangle using Heron's formula
        double s = (a + b + c) / 2.0;
        double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        System.out.println(area);
    }

    private static void areaRectangle(Scanner sc) {
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(a * b);
    }

    private static void areaCircle(Scanner sc) {
        int r = sc.nextInt();
        System.out.println(3.14 * Math.pow(r, 2));
    }
}