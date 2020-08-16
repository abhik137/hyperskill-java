package machine;

public enum Action {
    BUY("buy"),
    FILL("fill"),
    TAKE("take"),
    REMAINING("remaining"),
    EXIT("exit");

    String actionString;

    Action(String action) {
        this.actionString = action;
    }

    private String getActionString() {
        return this.actionString;
    }

    public static Action fromString(String text) {
        for (Action a: Action.values()) {
            if (text.equals(a.getActionString())) {
                return a;
            }
        }
        return null;
    }
}
