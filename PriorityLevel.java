public enum PriorityLevel {
    EMERGENCY(1),
    NORMAL(2);

    private int level;

    PriorityLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}