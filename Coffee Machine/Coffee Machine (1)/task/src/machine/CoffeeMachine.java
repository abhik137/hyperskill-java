package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int money;

    private CoffeeMachine() {
        this.water = 400;
        this.milk = 540;
        this.beans = 120;
        this.cups = 9;
        this.money = 550;
    }

    public void reportStatus() {
        System.out.println("The coffee machine has:\n" +
                water + " of water\n" +
                milk + " of milk\n" +
                beans + " of coffee beans\n" +
                cups + " of disposable cups\n" +
                money + " of money");
    }

    private void makeEspresso() {
        makeCoffee(250, 0,16, 4);
    }

    private void makeLatte() {
        makeCoffee(350, 75,20, 7);
    }

    private void makeCappuccino() {
        makeCoffee(200, 100,12, 6);
    }

    private void makeCoffee(int water, int milk, int beans, int cost) {
        if (this.water - water < 0)
            insufficientItem("water");
        else if (this.milk - milk < 0)
            insufficientItem("milk");
        else if (this.beans - beans < 0)
            insufficientItem("beans");
        else if (this.cups - 1 < 0)
            insufficientItem("cups");
        else {
            this.water -= water;
            this.milk -= milk;
            this.beans -= beans;
            this.cups -= 1;
            this.money += cost;
            System.out.println("I have enough resources, making you a coffee!");
        }
    }

    private void insufficientItem(String type) {
        System.out.println("Sorry, not enough " + type + "!");
    }

    public void buy(Scanner scan) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String item = scan.next();

        switch (item) {
            case "1":
                makeEspresso();
                break;
            case "2":
                makeLatte();
                break;
            case "3":
                makeCappuccino();
                break;
            case "back":
                System.out.println();
                mainMenu(scan);
                break;
            default:
                System.out.println("Unknown Coffee!");
                break;
        }
    }

    public void fill(Scanner scan) {
        System.out.println("Write how many ml of water do you want to add: ");
        int water = scan.nextInt();

        System.out.println("Write how many ml of milk do you want to add: ");
        int milk = scan.nextInt();

        System.out.println("Write how many grams of coffee beans do you want to add: ");
        int beans = scan.nextInt();

        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        int cups = scan.nextInt();

        this.refuel(water, milk, beans, cups);
    }

    private void refuel(int water, int milk, int beans, int cups) {
        this.water += water;
        this.milk += milk;
        this.beans += beans;
        this.cups += cups;
    }

    public void take() {
        System.out.println("I gave you $" + this.money);
        this.money = 0;
    }

    public void shutdown() {
        System.exit(0);
    }

    public void mainMenu(Scanner scan) {
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
        String action = scan.next();

        System.out.println();
        switch (action) {
            case "buy":
                this.buy(scan);
                break;
            case "fill":
                this.fill(scan);
                break;
            case "take":
                this.take();
                break;
            case "remaining":
                this.reportStatus();
                break;
            case "exit":
                this.shutdown();
                break;
            default:
                System.out.println("Invalid action!");
                break;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CoffeeMachine cm = new CoffeeMachine();
        Scanner scan = new Scanner(System.in);

        // while loop here emulates an event loop
        while (true) {
            cm.mainMenu(scan);
        }
    }
}
