enum DangerLevel {
    HIGH(3),
    MEDIUM(2),
    LOW(1);

    int level;

    DangerLevel(int i) {
        this.level = i;
    }

    public int getLevel() {
        return this.level;
    }
}