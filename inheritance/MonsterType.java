public enum MonsterType {
    HUMANOID("Humanoid"),
    FIEND("Fiend"),
    DRAGON("Dragon");

    private String value;

    MonsterType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return getValue();
    }
}
