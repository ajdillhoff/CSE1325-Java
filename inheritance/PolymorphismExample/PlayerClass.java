public enum PlayerClass {
    WARRIOR("Warrior"),
    RANGER("Ranger"),
    MAGE("Mage");

    private String value;

    PlayerClass(String value) {
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
