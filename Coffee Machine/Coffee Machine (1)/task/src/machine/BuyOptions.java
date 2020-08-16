package machine;

public enum BuyOptions {
    ESPRESSO("1"),
    LATTE("2"),
    CAPPUCCINO("3"),
    BACK("back");

    String input;

    BuyOptions(String input) {
        this.input = input;
    }

    private String getInputString() {
        return this.input;
    }

    public static BuyOptions fromString(String str) {
        for (BuyOptions option: BuyOptions.values()) {
            if (str.equals(option.getInputString())) {
                return option;
            }
        }
        return null;
    }
}
