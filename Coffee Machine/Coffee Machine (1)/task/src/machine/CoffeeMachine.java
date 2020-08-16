package machine;

import java.util.List;
import java.util.Scanner;

public class CoffeeMachine {
    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int money;

    private MachineState currentState;
    private final List<MachineState> intermediateStates = List.of(
            MachineState.FILLING_WATER,
            MachineState.FILLING_MILK,
            MachineState.FILLING_BEANS,
            MachineState.FILLING_CUPS,
            MachineState.SELECT_COFFEE
    );

    private CoffeeMachine() {
        this.water = 400;
        this.milk = 540;
        this.beans = 120;
        this.cups = 9;
        this.money = 550;
        this.currentState = MachineState.READY;
    }

    private void insufficientItem(String item) {
        System.out.println("Sorry, not enough " + item + "!");
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

    private void makeEspresso() {
        makeCoffee(250, 0,16, 4);
    }

    private void makeLatte() {
        makeCoffee(350, 75,20, 7);
    }

    private void makeCappuccino() {
        makeCoffee(200, 100,12, 6);
    }

    public void buy(String input) {
        if (currentState == MachineState.TRANSACTION_STARTED) {
            System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
            currentState = currentState.nextState();
            return;
        }

        BuyOptions option = BuyOptions.fromString(input);

        switch (option) {
            case ESPRESSO:
                makeEspresso();
                break;
            case LATTE:
                makeLatte();
                break;
            case CAPPUCCINO:
                makeCappuccino();
                break;
            case BACK:
                System.out.println();
                break;
            default:
                System.out.println("Unknown Coffee!");
                break;
        }

        currentState = currentState.nextState();
    }

    public void fill(int value) {
        switch (currentState) {
            case REFILL_INITIATED:
                System.out.println("Write how many ml of water do you want to add: ");
                break;
            case FILLING_WATER:
                this.water += value;
                System.out.println("Write how many ml of milk do you want to add: ");
                break;
            case FILLING_MILK:
                this.milk += value;
                System.out.println("Write how many grams of coffee beans do you want to add: ");
                break;
            case FILLING_BEANS:
                this.beans += value;
                System.out.println("Write how many disposable cups of coffee do you want to add: ");
                break;
            case FILLING_CUPS:
                this.cups += value;
                break;
            default:
                System.out.println("Invalid Fill State");
                break;
        }

        currentState = currentState.nextState();
    }

    public void reportStatus() {
        System.out.println("The coffee machine has:\n" +
                water + " of water\n" +
                milk + " of milk\n" +
                beans + " of coffee beans\n" +
                cups + " of disposable cups\n" +
                money + " of money");
        currentState = currentState.nextState();
    }

    public void take() {
        System.out.println("I gave you $" + this.money);
        this.money = 0;

        currentState = currentState.nextState();
    }

    public void shutdown() {
        currentState = MachineState.POWERED_DOWN;
        System.exit(0);
    }

    public void action(String input) {
        Action action = Action.fromString(input);

        System.out.println();
        switch (action) {
            case BUY:
                currentState = MachineState.TRANSACTION_STARTED;
                this.buy(input);
                break;
            case FILL:
                currentState = MachineState.REFILL_INITIATED;
                this.fill(-1);
                break;
            case TAKE:
                currentState = MachineState.WITHDRAWING_MONEY;
                this.take();
                break;
            case REMAINING:
                currentState = MachineState.REPORTING_STATUS;
                this.reportStatus();
                break;
            case EXIT:
                this.shutdown();
                break;
            default:
                System.out.println("Invalid action!");
                break;
        }
    }

    public void inputInterrupt(String input) {
        switch (currentState) {
            case READY:
                this.action(input);
                break;
            case TRANSACTION_STARTED:
            case REFILL_INITIATED:  // these states won't be reached anyway
                break;
            case REPORTING_STATUS:
            case WITHDRAWING_MONEY: // these states won't be reached anyway
                break;
            case SELECT_COFFEE:
                this.buy(input);
                break;
            case FILLING_WATER:
            case FILLING_MILK:
            case FILLING_BEANS:
            case FILLING_CUPS:
                this.fill(Integer.parseInt(input));
                break;
            case POWERED_DOWN:
                break;
            default:
                System.out.println("Invalid State!");
                break;
        }

        if (!intermediateStates.contains(currentState))
            System.out.println("\nWrite action (buy, fill, take, remaining, exit): ");    // shouldn't show up for in-progress states
    }

    public static void main(String[] args) {
        CoffeeMachine cm = new CoffeeMachine();
        Scanner scan = new Scanner(System.in);
        System.out.println("Write action (buy, fill, take, remaining, exit): ");

        // while loop here emulates an event loop
        while (true) {
            if (scan.hasNextLine()) {
                cm.inputInterrupt(scan.nextLine());
            }
        }
    }
}
